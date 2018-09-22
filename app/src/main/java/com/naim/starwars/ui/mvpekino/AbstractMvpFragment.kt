/*
 * Copyright (c) 2017 Ekino
 */
package com.naim.starwars.ui.mvpekino

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Base implementation of the [BaseView] for [Fragment]
 *
 * @author nhaan
 * @version $Id: 0fd7739b367de362078be2722a5446cff8157b6b $
 *
 * @param P
 */
abstract class AbstractMvpFragment<P : BasePresenter>
    : Fragment() {

    open val TAG = "ekDroid-mvp.fragment"

    abstract val presenter: P

    abstract val defaultLayout: Int

    val fragmentTag = Companion.fragmentTag

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? =
            inflater.inflate(defaultLayout, container, false)

    @CallSuper
    override fun onResume() {
        Log.v(TAG, "onResume(): " + this.toString())
        super.onResume()
        presenter.resume()
    }

    @CallSuper
    override fun onPause() {
        Log.v(TAG, "onPause(): " + this.toString())
        presenter.pause()
        super.onPause()
    }

    override fun onDestroy() {
        Log.v(TAG, "onDestroy(): " + this.toString())
        super.onDestroy()
    }

    companion object {
        val fragmentTag: String
            get() = this::class.java.simpleName
    }

    /**
     * This method can be overridden by subclassing Fragment
     * to allow custom back-press event handling
     * inside the Fragment
     */
    open fun onBackPressed(): Boolean {
        return false
    }
}
