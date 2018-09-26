package com.naim.starwars.domain.interactor

import com.naim.starwars.domain.DataRepository
import com.naim.starwars.domain.converter.TripNetworkToUiTripConverter
import com.naim.starwars.ui.model.UITripListItemModel
import io.reactivex.Observable

/**
 * GetTripListUseCase -
 *
 * @author naim
 * @version $Id$
 */
class GetTripListUseCase(private val dataRepository: DataRepository,
                         private val tripNetworkToUiTripConverter: TripNetworkToUiTripConverter) {

    fun execute(): Observable<List<UITripListItemModel>> =
            dataRepository.getTripList()
                    .map { tripNetworkToUiTripConverter.convert(it) }
}