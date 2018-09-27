package com.naim.starwars.domain.converter

import com.naim.starwars.data.model.TripModel
import com.naim.starwars.ui.model.ViewTripListItemModel

/**
 * TripNetworkListToUiTripListConverter -
 *
 * @author naim
 * @version $Id$
 */
class TripNetworkListToUiTripListConverter {

    fun convert(tripList: List<TripModel>): List<ViewTripListItemModel> {
        val uiTripList = mutableListOf<ViewTripListItemModel>()
        tripList.forEach {
            uiTripList.add(
                    ViewTripListItemModel(
                            id = it.id,
                            pilotName = it.pilot.name,
                            pilotAvatar = it.pilot.avatar,
                            pickupName = it.pick_up.name,
                            dropoffName = it.drop_off.name
                    )
            )
        }
        return uiTripList
    }
}