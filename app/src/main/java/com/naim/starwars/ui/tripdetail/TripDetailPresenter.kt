package com.naim.starwars.ui.tripdetail

import android.util.Log
import com.naim.starwars.domain.interactor.GetATripUseCase
import com.naim.starwars.ui.Navigator
import com.naim.starwars.ui.mapper.TripDetailMapper
import com.naim.starwars.ui.mvpekino.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * TripDetailPresenter -
 *
 * @author naim
 * @version $Id$
 */
class TripDetailPresenter(view: TripDetailContract.View, navigator: Navigator,
                          private val getATripUseCase: GetATripUseCase,
                          private val tripDetailMapper: TripDetailMapper,
                          private val tripId: Int)
    : MvpPresenter<Navigator, TripDetailContract.View>(view, navigator),
        TripDetailContract.Presenter {

    companion object {
        private val TAG = TripDetailPresenter::class.java.simpleName
    }

    override fun resume() {
        super.resume()
        loadTrip()
    }

    private fun loadTrip() {
        view.setLoadingState(true)
        val disposable = getATripUseCase.execute(tripId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { tripDetailMapper.transform(it) }
                .subscribe({
                    view.setData(it)
                    view.setLoadingState(false)
                }, {
                    Log.e(TAG, it.message)
                    view.setLoadingState(false)
                    view.showError()
                })
        addToAutoDisposeList(disposable)
    }

}
