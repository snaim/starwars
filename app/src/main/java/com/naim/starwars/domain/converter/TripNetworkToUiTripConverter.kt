package com.naim.starwars.domain.converter

import com.naim.starwars.data.model.TripModel
import com.naim.starwars.ui.model.UITripListItemModel

/**
 * TripNetworkToUiTripConverter -
 *
 * @author naim
 * @version $Id$
 */
class TripNetworkToUiTripConverter {

    fun convert(tripList: List<TripModel>): List<UITripListItemModel> {
        val uiTripList = mutableListOf<UITripListItemModel>()
        tripList.forEach {
            uiTripList.add(
                    UITripListItemModel(
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