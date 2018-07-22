package com.naim.mymusic.ui.musiclist

import android.util.Log
import com.naim.mymusic.domain.GetMusicUseCase
import com.naim.mymusic.ui.Navigator
import com.naim.mymusic.ui.mvpekino.MvpPresenter

/**
 * MusicListPresenter -
 *
 * @author naim
 * @version $Id$
 */
class MusicListPresenter(view: MusicListContract.View, navigator: Navigator,
        private val getMusicUseCase: GetMusicUseCase)
    : MvpPresenter<Navigator, MusicListContract.View>(view, navigator),
        MusicListContract.Presenter {

    companion object {
        private val TAG = MusicListPresenter::class.java.simpleName
    }

    override fun resume() {
        super.resume()
        initList()
    }

    private fun initList() {
        val disposable = getMusicUseCase.execute()
                .subscribe({
                    view.setData(it)
                }, {
                    Log.e(TAG, it.message)
                    view.showError("An error occured while loading your music")
                })

        addToAutoDisposeList(disposable)
    }
}
