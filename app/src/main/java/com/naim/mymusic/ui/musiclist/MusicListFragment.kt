package com.naim.mymusic.ui.musiclist

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.naim.mymusic.MainActivity
import com.naim.mymusic.R
import com.naim.mymusic.ui.model.MusicModel
import com.naim.mymusic.ui.mvpekino.MvpKodeinFragment
import kotlinx.android.synthetic.main.fragment_music_list.empty_state
import kotlinx.android.synthetic.main.fragment_music_list.rv_music
import kotlinx.android.synthetic.main.fragment_music_list.swipe_refresh

/**
 * MusicListFragment -
 *
 * @author naim
 * @version $Id$
 */
class MusicListFragment : MvpKodeinFragment<MusicListContract.Presenter>(), MusicListContract.View {

    override val defaultLayout: Int = R.layout.fragment_music_list

    override val presenter: MusicListContract.Presenter by injector.instance()

    private val controller = MusicEpoxyController()

    companion object {
        fun newInstance(): MusicListFragment {
            return MusicListFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_music.adapter = controller.adapter
        rv_music.layoutManager = LinearLayoutManager(context)

        swipe_refresh.setOnRefreshListener {
            presenter.onRefresh()
            swipe_refresh.isRefreshing = false
        }
    }

    override fun setData(data: Map<Int, List<MusicModel>>) {
        setEmptyState(data.isEmpty())
        if (!data.isEmpty()) {
            controller.setData(data)
        }
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun setLoadingState(isLoading: Boolean) {
        (activity as MainActivity).setLoadingState(isLoading)
    }

    override fun provideOverridingModule() = Kodein.Module {
        bind<MusicListContract.View>() with instance(this@MusicListFragment)
    }

    private fun setEmptyState(isVisible: Boolean) {
        rv_music.visibility = if (isVisible) View.GONE else View.VISIBLE
        empty_state.visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}
