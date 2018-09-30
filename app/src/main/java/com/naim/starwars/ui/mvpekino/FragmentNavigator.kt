/*
 * Copyright (c) 2017 Ekino
 */
package com.naim.starwars.ui.mvpekino

import android.content.Context
import android.support.v4.app.FragmentManager
import android.util.Log
import com.naim.starwars.R

/**
 * FragmentNavigator -
 *
 * @author nhaan
 * @version $Id: 25ecf4d2dc13b2cc30b7f0e39208be082e989617 $
 *
 * @param context
 * @param fragmentManager
 * @param containerViewId
 */
abstract class FragmentNavigator(protected val context: Context,
        private val fragmentManager: FragmentManager,
        private val containerViewId: Int) {

    protected open val TAG = "ekDroid-mvp.navigator"

    /**
     * This method must be called inside the [android.app.Activity.onBackPressed] method by the
     * Activity. It allows to implement custom behavior inside Fragments.
     *
     * @return true if the event has been handled by a Fragment (should be ignored by the Activity)
     * @return false if the event has not been handled by a Fragment (should be handled by the Activity)
     */
    fun onBackPressed(): Boolean {
        var handled = false

        val fm = fragmentManager

        val lastEntry = fm.backStackEntryCount - 1

        var currentFragment: MvpKodeinFragment<*>? = null

        if (lastEntry >= 0) {
            val backEntry = fm.getBackStackEntryAt(lastEntry)
            val tag = backEntry.name

            val fragment = fm.findFragmentByTag(tag)
            if (fragment is MvpKodeinFragment<*>) {
                currentFragment = fragment
            }
        }

        if (currentFragment != null) {
            handled = currentFragment.onBackPressed()
        }

        return handled
    }

    open fun goBack() {
        fragmentManager.popBackStackImmediate()
    }

    /**
     * To be called in {@link Activity#onStart()} and overriden in App Navigator
     * Should implement display logic for the 1st screen to display after Activity creation/re-creation,
     * regarding to App state (for instance is user already logged-in, app configuration, etc...)
     *
     * @param isAppInitialized Indicates whether the activity has already been initialized in the process,
     *  allowing to detect if the process has been killed and restored by Android
     *
     * @see [medium](https://medium.com/inloop/android-process-kill-and-the-big-implications-for-your-app-1ecbed4921cb)
     * @see [stackoverflow](https://stackoverflow.com/questions/29701660/can-i-detect-if-android-has-killed-the-application-task-process-from-a-notific/29802601#29802601)
     */
    abstract fun displayOrRestoreScreenOnActivityCreate(isAppInitialized: Boolean)

    protected fun backStackHasFragments(): Boolean {
        return fragmentManager.backStackEntryCount > 0
    }

    protected fun restoreLastFragment() {
        Log.d(TAG, "Restoring Last Fragment")
        val fragmentManager = fragmentManager
        val fragmentTag = fragmentManager
                .getBackStackEntryAt(fragmentManager.backStackEntryCount - 1)
                .name
        fragmentManager.popBackStack(fragmentTag, 0)
    }

    protected fun clearBackStack() {
        if (!backStackHasFragments()) {
            Log.d(TAG, "empty fragment backstack")
            return
        }

        val entry = fragmentManager.getBackStackEntryAt(0)
        if (entry == null) {
            Log.d(TAG, "null fragment backstack entry")
            return
        }

        fragmentManager.popBackStackImmediate(entry.id,
                FragmentManager.POP_BACK_STACK_INCLUSIVE)

        fragmentManager.executePendingTransactions()
    }

    protected fun displayAndSetRootFragment(fragment: AbstractMvpFragment<*>) {
        clearBackStack()

        fragmentManager
                .beginTransaction()
                .replace(containerViewId, fragment, fragment.fragmentTag)
                .commit()
    }

    protected fun addToBackStackWithoutAnimation(newFragment: AbstractMvpFragment<*>) {
        fragmentManager
                .beginTransaction()
                .replace(containerViewId, newFragment, newFragment.fragmentTag)
                .addToBackStack(newFragment.fragmentTag)
                .commit()
    }
}
