package com.naim.mymusic.ui.musiclist

import android.util.Log
import com.naim.mymusic.ui.Navigator
import com.naim.mymusic.ui.model.MusicModel
import com.naim.mymusic.ui.mvpekino.MvpPresenter
import io.reactivex.Observable

/**
 * MusicListPresenter -
 *
 * @author naim
 * @version $Id$
 */
class MusicListPresenter(view: MusicListContract.View, navigator: Navigator)
    : MvpPresenter<Navigator, MusicListContract.View>(view, navigator),
        MusicListContract.Presenter {

    private val music1 = MusicModel(
            1,
            "accusamus beatae ad facilis cum similique qui sunt",
            "http://placehold.it/600/92c952",
            "http://placehold.it/150/92c952")
    private val music2 = MusicModel(
            2,
            "reprehenderit est deserunt velit ipsam",
            "http://placehold.it/600/771796",
            "http://placehold.it/150/771796")
    private val music3 = MusicModel(
            3,
            "officia porro iure quia iusto qui ipsa ut modi",
            "http://placehold.it/600/24f355",
            "http://placehold.it/150/24f355")

    private val listMock: Map<Int, List<MusicModel>> =
            mapOf(1 to listOf(music1, music2), 2 to listOf(music3))

    companion object {
        private val TAG = MusicListPresenter::class.java.simpleName
    }

    override fun resume() {
        super.resume()
        initList()
    }

    private fun initList() {
        val disposable = Observable.just(listMock)
                .subscribe({
                    view.setData(it)
                }, {
                    Log.e(TAG, "oups")
                })

        addToAutoDisposeList(disposable)
    }
}
