package com.naim.starwars.domain.interactor

import com.naim.starwars.domain.DataRepository
import com.naim.starwars.domain.converter.TripNetworkItemToUiTripItemConverter
import com.naim.starwars.domain.model.TripDetailModel
import io.reactivex.Single

/**
 * GetTripListUseCase -
 *
 * @author naim
 * @version $Id$
 */
class GetATripUseCase(
        private val dataRepository: DataRepository,
        private val tripNetworkItemToUiTripItemConverter: TripNetworkItemToUiTripItemConverter) {

    fun execute(id: Int): Single<TripDetailModel> =
            dataRepository.getATrip(id)
                    .map { tripNetworkItemToUiTripItemConverter.convert(it) }
}