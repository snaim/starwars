package com.naim.mymusic.ui.musiclist

import com.naim.mymusic.ui.model.MusicModel
import com.naim.mymusic.ui.mvpekino.BasePresenter
import com.naim.mymusic.ui.mvpekino.BaseView

/**
 * MusicListContract -
 *
 * @author naim
 * @version $Id$
 */
interface MusicListContract {

    interface View : BaseView<Presenter> {
        fun setData(data: Map<Int, List<MusicModel>>)
    }

    interface Presenter : BasePresenter {
    }
}
