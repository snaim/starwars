package com.naim.starwars.domain.converter

import com.naim.starwars.data.model.TripModel
import com.naim.starwars.ui.model.TripListItemViewModel

/**
 * TripListConverter -
 *
 * @author naim
 * @version $Id$
 */
class TripListConverter {

    fun convert(tripList: List<TripModel>): List<TripListItemViewModel> {
        val domainTripList = mutableListOf<TripListItemViewModel>()
        tripList.forEach {
            domainTripList.add(
                    TripListItemViewModel(
                            id = it.id,
                            pilotName = it.pilot.name,
                            pilotAvatar = it.pilot.avatar,
                            pickupName = it.pick_up.name,
                            dropoffName = it.drop_off.name
                    )
            )
        }
        return domainTripList
    }
}