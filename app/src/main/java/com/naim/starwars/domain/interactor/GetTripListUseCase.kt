package com.naim.starwars.domain.interactor

import com.naim.starwars.domain.DataRepository
import com.naim.starwars.domain.converter.TripListConverter
import com.naim.starwars.ui.model.TripListItemViewModel
import io.reactivex.Observable

/**
 * GetTripListUseCase -
 *
 * @author naim
 * @version $Id$
 */
class GetTripListUseCase(private val dataRepository: DataRepository,
                         private val tripListConverter: TripListConverter) {

    fun execute(): Observable<List<TripListItemViewModel>> =
            dataRepository.getTripList()
                    .map { tripListConverter.convert(it) }
}