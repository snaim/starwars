package com.naim.starwars.domain.converter

import com.naim.starwars.data.model.TripModel
import com.naim.starwars.domain.model.TripListItemModel

/**
 * TripListConverter -
 *
 * @author naim
 * @version $Id$
 */
class TripListConverter {

    fun convert(tripList: List<TripModel>): List<TripListItemModel> {
        val domainTripList = mutableListOf<TripListItemModel>()
        tripList.forEach {
            domainTripList.add(
                    TripListItemModel(
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