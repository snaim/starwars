package com.naim.starwars.ui

import android.content.Context
import android.support.v4.app.FragmentManager
import com.naim.starwars.ui.triplist.TripListFragment
import com.naim.starwars.ui.mvpekino.FragmentNavigator
import com.naim.starwars.ui.tripdetail.TripDetailFragment

/**
 * AppFragmentNavigator -
 *
 * @author naim
 * @version $Id$
 */
class AppFragmentNavigator(context: Context, fragmentManager: FragmentManager, containerViewId: Int)
    : FragmentNavigator(context, fragmentManager, containerViewId), Navigator {

    override val TAG = "starwars.navigator"

    override fun displayOrRestoreScreenOnActivityCreate(isAppInitialized: Boolean) {
        displayTripList()
    }

    override fun displayTripList() {
        displayAndSetRootFragment(TripListFragment.newInstance())
    }

    override fun displayTripDetail(id: Int) {
        addToBackStackWithoutAnimation(TripDetailFragment.newInstance(id))
    }

}
