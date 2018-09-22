package com.naim.starwars.ui.musiclist

import com.naim.starwars.ui.model.MusicModel
import com.naim.starwars.ui.mvpekino.BasePresenter
import com.naim.starwars.ui.mvpekino.BaseView

/**
 * MusicListContract -
 *
 * @author naim
 * @version $Id$
 */
interface MusicListContract {

    interface View : BaseView<Presenter> {
        fun setData(data: Map<Int, List<MusicModel>>)
        fun showError(message: String)
        fun setLoadingState(isLoading: Boolean)
    }

    interface Presenter : BasePresenter {
        fun onRefresh()
    }
}
