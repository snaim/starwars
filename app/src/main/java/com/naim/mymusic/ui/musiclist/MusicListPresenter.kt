package com.naim.mymusic.ui.musiclist

import com.naim.mymusic.ui.Navigator
import com.naim.mymusic.ui.mvpekino.MvpPresenter

/**
 * MusicListPresenter -
 *
 * @author naim
 * @version $Id$
 */
class MusicListPresenter(view: MusicListContract.View, navigator: Navigator)
    : MvpPresenter<Navigator, MusicListContract.View>(view, navigator),
        MusicListContract.Presenter {

    companion object {
        private val TAG = MusicListPresenter::class.java.simpleName
    }
}
