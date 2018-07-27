package com.naim.mymusic.ui.musiclist

import android.util.Log
import com.naim.mymusic.domain.interactor.GetMusicUseCase
import com.naim.mymusic.domain.interactor.RefreshDataFromNetworkUseCase
import com.naim.mymusic.ui.Navigator
import com.naim.mymusic.ui.mvpekino.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * MusicListPresenter -
 *
 * @author naim
 * @version $Id$
 */
class MusicListPresenter(view: MusicListContract.View, navigator: Navigator,
        private val getMusicUseCase: GetMusicUseCase,
        private val refreshDataFromNetworkUseCase: RefreshDataFromNetworkUseCase)
    : MvpPresenter<Navigator, MusicListContract.View>(view, navigator),
        MusicListContract.Presenter {

    companion object {
        private val TAG = MusicListPresenter::class.java.simpleName
    }

    override fun resume() {
        super.resume()
        initList()
    }

    override fun onRefresh() {
        getDataFromNetwork()
    }

    private fun initList() {
        view.setLoadingState(true)
        val disposable = getMusicUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.setData(it)
                    view.setLoadingState(false)
                }, {
                    Log.e(TAG, it.message)
                    view.setLoadingState(false)
                    view.showError("An error occured while loading your music") // TODO : string
                })

        addToAutoDisposeList(disposable)
    }

    private fun getDataFromNetwork() {
        refreshDataFromNetworkUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }
}
