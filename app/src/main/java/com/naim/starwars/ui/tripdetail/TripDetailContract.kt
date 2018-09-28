package com.naim.starwars.ui.tripdetail

import com.naim.starwars.ui.model.ViewTripDetailModel
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
        fun setData(trip: ViewTripDetailModel)
    }

    interface Presenter : BasePresenter
}