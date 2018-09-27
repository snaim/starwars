package com.naim.starwars.ui.tripdetail

import com.naim.starwars.ui.mvpekino.BasePresenter
import com.naim.starwars.ui.mvpekino.BaseView

/**
 * TripDetailContract -
 *
 * @author naim
 * @version $Id$
 */
interface TripDetailContract {

    interface View : BaseView<Presenter> {
        fun showError(message: String)
        fun setLoadingState(isLoading: Boolean)
    }

    interface Presenter : BasePresenter
}
