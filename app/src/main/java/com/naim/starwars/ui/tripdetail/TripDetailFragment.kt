package com.naim.starwars.ui.tripdetail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.naim.starwars.MainActivity
import com.naim.starwars.R
import com.naim.starwars.ui.mvpekino.MvpKodeinFragment

/**
 * TripDetailFragment -
 *
 * @author naim
 * @version $Id$
 */
class TripDetailFragment
    : MvpKodeinFragment<TripDetailContract.Presenter>(), TripDetailContract.View {

    override val defaultLayout: Int = R.layout.fragment_trip_detail

    override val presenter: TripDetailContract.Presenter by injector.instance()

    companion object {
        fun newInstance(): TripDetailFragment {
            return TripDetailFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun setLoadingState(isLoading: Boolean) {
        (activity as MainActivity).setLoadingState(isLoading)
    }

    override fun provideOverridingModule() = Kodein.Module {
        bind<TripDetailContract.View>() with instance(this@TripDetailFragment)
    }

}
