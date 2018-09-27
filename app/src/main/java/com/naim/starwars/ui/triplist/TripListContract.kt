package com.naim.starwars.ui.triplist

import com.naim.starwars.ui.model.ViewTripListItemModel
import com.naim.starwars.ui.mvpekino.BasePresenter
import com.naim.starwars.ui.mvpekino.BaseView

/**
 * TripListContract -
 *
 * @author naim
 * @version $Id$
 */
interface TripListContract {

    interface View : BaseView<Presenter> {
        fun setData(data: List<ViewTripListItemModel>)
        fun showError(message: String)
        fun setLoadingState(isLoading: Boolean)
    }

    interface Presenter : BasePresenter{
        fun onRefresh()
        fun onClickOnPhone(id: Int)
    }
}
