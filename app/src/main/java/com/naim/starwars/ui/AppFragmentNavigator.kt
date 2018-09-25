package com.naim.starwars.ui

import android.content.Context
import android.support.v4.app.FragmentManager
import com.naim.starwars.ui.triplist.TripListFragment
import com.naim.starwars.ui.mvpekino.FragmentNavigator

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
        displayMusicList()
    }

    override fun displayMusicList() {
        displayAndSetRootFragment(TripListFragment.newInstance())
    }
}
