/*
 * Copyright (c) 2017 Ekino
 */
package com.naim.starwars.ui.mvpekino

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Base implementation of the [BasePresenter]
 *
 * @author nhaan
 * @version $Id: 8490890268fd090c58b13673bb3516b8b0d1ecc6 $
 *
 * @param view Reference to the view implementing *Contract.View interface
 * @param navigator Reference to an App navigator
 */
abstract class MvpPresenter<out N, V : BaseView<out BasePresenter>>(protected val view: V,
        protected val navigator: N) {

    private val subscriptions: CompositeDisposable

    init {
        subscriptions = CompositeDisposable()
    }

    /**
     * Method called by [MvpFragment.onResume] method
     * View initialization should be done in this method.
     */
    open fun resume() {
        //noop
    }

    /**
     * Method called by [MvpFragment.onPause] method
     * Any resource-consuming operation not needed outside of this view
     * should be aborted in this method.
     */
    fun pause() {
        disposeSubscriptions()
    }

    /**
     * A disposable added through this method will be automatically disposed when Presenter
     * is stopped.
     *
     * @param disposable The Disposable (subscription) to add
     */
    protected fun addToAutoDisposeList(disposable: Disposable) {
        subscriptions.add(disposable)
    }

    /**
     * Manually trigger clearing Rx Subscription added using {addToAutoDisposeList()}
     */
    protected fun disposeSubscriptions() {
        subscriptions.clear()
    }

    fun Disposable.autoDispose() = addToAutoDisposeList(this)
}

