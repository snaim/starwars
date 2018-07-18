package com.naim.mymusic.ui.musiclist

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.naim.mymusic.R
import com.naim.mymusic.ui.model.MusicModel
import com.naim.mymusic.ui.mvpekino.MvpKodeinFragment
import kotlinx.android.synthetic.main.fragment_music_list.rv_music

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
    }

    override fun setData(data: Map<Int, List<MusicModel>>) {
        controller.setData(data)
    }

    override fun provideOverridingModule() = Kodein.Module {
        bind<MusicListContract.View>() with instance(this@MusicListFragment)
    }
}
