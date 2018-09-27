package com.naim.starwars.domain.interactor

import com.naim.starwars.domain.DataRepository
import com.naim.starwars.domain.converter.TripNetworkListToUiTripListConverter
import com.naim.starwars.ui.model.ViewTripListItemModel
import io.reactivex.Observable

/**
 * GetTripListUseCase -
 *
 * @author naim
 * @version $Id$
 */
class GetTripListUseCase(private val dataRepository: DataRepository,
                         private val tripNetworkListToUiTripListConverter: TripNetworkListToUiTripListConverter) {

    fun execute(): Observable<List<ViewTripListItemModel>> =
            dataRepository.getTripList()
                    .map { tripNetworkListToUiTripListConverter.convert(it) }
}