package com.naim.starwars.ui.tripdetail

import com.naim.starwars.domain.interactor.GetTripListUseCase
import com.naim.starwars.ui.Navigator
import com.naim.starwars.ui.mvpekino.MvpPresenter

/**
 * TripDetailPresenter -
 *
 * @author naim
 * @version $Id$
 */
class TripDetailPresenter(view: TripDetailContract.View, navigator: Navigator,
                          private val getTripListUseCase: GetTripListUseCase)
    : MvpPresenter<Navigator, TripDetailContract.View>(view, navigator),
        TripDetailContract.Presenter {

    companion object {
        private val TAG = TripDetailPresenter::class.java.simpleName
    }

    override fun resume() {
        super.resume()
        loadList()
    }

    private fun loadList() {
        /*view.setLoadingState(true)
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
