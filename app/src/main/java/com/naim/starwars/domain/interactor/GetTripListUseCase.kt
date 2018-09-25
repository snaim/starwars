package com.naim.starwars.domain.interactor

import com.naim.starwars.domain.DataRepository
import com.naim.starwars.domain.converter.MusicRoomToMusicModelConverter
import com.naim.starwars.ui.model.UITripListItemModel
import io.reactivex.Observable

/**
 * GetTripListUseCase -
 *
 * @author naim
 * @version $Id$
 */
class GetTripListUseCase(private val dataRepository: DataRepository,
                         private val musicRoomToMusicModelConverter: MusicRoomToMusicModelConverter) {

    fun execute(): Observable<List<UITripListItemModel>> =
            dataRepository.getTripList()
                    .map { musicRoomToMusicModelConverter.convert(it) }
}