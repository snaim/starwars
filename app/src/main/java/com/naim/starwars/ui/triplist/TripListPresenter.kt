package com.naim.starwars.ui.triplist

import android.util.Log
import com.naim.starwars.domain.interactor.GetTripListUseCase
import com.naim.starwars.ui.Navigator
import com.naim.starwars.ui.model.UITripListItemModel
import com.naim.starwars.ui.mvpekino.MvpPresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * TripListPresenter -
 *
 * @author naim
 * @version $Id$
 */
class TripListPresenter(view: TripListContract.View, navigator: Navigator,
                        private val getTripListUseCase: GetTripListUseCase)
    : MvpPresenter<Navigator, TripListContract.View>(view, navigator),
        TripListContract.Presenter {

    companion object {
        private val TAG = TripListPresenter::class.java.simpleName
        private val one = UITripListItemModel(1, "Dark Vador", "/static/dark-vador.png", "Yavin 4", "Naboo")
        private val two = UITripListItemModel(2, "Admiral Ackbar", "/static/admiral-ackbar.png", "Naboo", "Coruscant")
    }

    override fun resume() {
        super.resume()
        initList()
    }

    private fun initList() {
        view.setLoadingState(true)

        Observable.just(listOf(one, two))
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

        /*
        val disposable = getTripListUseCase.execute()
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

        addToAutoDisposeList(disposable)*/
    }

}
