package com.naim.mymusic.ui.musiclist

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

    }

    interface Presenter : BasePresenter {
    }
}
