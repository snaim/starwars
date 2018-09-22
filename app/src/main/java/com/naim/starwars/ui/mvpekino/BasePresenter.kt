/*
 * Copyright (c) 2017 Ekino
 */
package com.naim.starwars.ui.mvpekino

/**
 * The minimal contract to implement for presenters in MVP
 *
 * @author nhaan
 * @version $Id: e734277bd4e9deba7301deaa3e70dd23141d016a $
 */
interface BasePresenter {

    /**
     * What to do when starting/resuming this presenter
     */
    fun resume()

    /**
     * What to do when stopping/pausing this presenter
     */
    fun pause()
}
