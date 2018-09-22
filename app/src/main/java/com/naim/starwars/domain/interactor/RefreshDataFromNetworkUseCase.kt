package com.naim.starwars.domain.interactor

import com.naim.starwars.data.network.MusicAPI
import com.naim.starwars.data.room.model.MusicRoom
import com.naim.starwars.domain.DataRepository
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