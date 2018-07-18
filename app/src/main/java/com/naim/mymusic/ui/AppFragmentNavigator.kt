package com.naim.mymusic.ui

import android.content.Context
import android.support.v4.app.FragmentManager
import com.naim.mymusic.ui.musiclist.MusicListFragment
import com.naim.mymusic.ui.mvpekino.FragmentNavigator

/**
 * AppFragmentNavigator -
 *
 * @author naim
 * @version $Id$
 */
class AppFragmentNavigator(context: Context, fragmentManager: FragmentManager, containerViewId: Int)
    : FragmentNavigator(context, fragmentManager, containerViewId), Navigator {

    override val TAG = "my-music.navigator"

    override fun displayOrRestoreScreenOnActivityCreate(isAppInitialized: Boolean) {
        displayMusicList()
    }

    override fun displayMusicList() {
        displayAndSetRootFragment(MusicListFragment.newInstance())
    }
}
