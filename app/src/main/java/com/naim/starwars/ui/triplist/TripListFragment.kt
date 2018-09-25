package com.naim.starwars.ui.triplist

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.naim.starwars.MainActivity
import com.naim.starwars.R
import com.naim.starwars.ui.model.UITripListItemModel
import com.naim.starwars.ui.mvpekino.MvpKodeinFragment
import kotlinx.android.synthetic.main.fragment_trip_list.empty_state
import kotlinx.android.synthetic.main.fragment_trip_list.rv_music

/**
 * TripListFragment -
 *
 * @author naim
 * @version $Id$
 */
class TripListFragment : MvpKodeinFragment<TripListContract.Presenter>(), TripListContract.View {

    override val defaultLayout: Int = R.layout.fragment_trip_list

    override val presenter: TripListContract.Presenter by injector.instance()

    private val controller = TripEpoxyController()

    companion object {
        fun newInstance(): TripListFragment {
            return TripListFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_music.adapter = controller.adapter
        rv_music.layoutManager = LinearLayoutManager(context)
    }

    override fun setData(data: List<UITripListItemModel>) {
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
        bind<TripListContract.View>() with instance(this@TripListFragment)
    }

    private fun setEmptyState(isVisible: Boolean) {
        rv_music.visibility = if (isVisible) View.GONE else View.VISIBLE
        empty_state.visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}
