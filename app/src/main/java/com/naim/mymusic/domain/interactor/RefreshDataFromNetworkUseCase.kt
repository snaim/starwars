package com.naim.mymusic.domain.interactor

import com.naim.mymusic.data.network.MusicAPI
import com.naim.mymusic.data.room.model.MusicRoom
import com.naim.mymusic.domain.DataRepository
import io.reactivex.Completable

/**
 * RefreshDataFromNetworkUseCase -
 *
 * @author naim
 * @version $Id$
 */
class RefreshDataFromNetworkUseCase(private val dataRepository: DataRepository,
        private val musicAPI: MusicAPI) {

    fun execute(): Completable =
            Completable.fromAction {
                musicAPI.load()
                        .onErrorReturn {
                            return@onErrorReturn listOf<MusicRoom>()
                        }
                        .subscribe {
                            dataRepository.saveMusic(it)
                        }
            }
}