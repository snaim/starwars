package com.naim.starwars.domain.converter

import com.naim.starwars.data.model.TripModel
import com.naim.starwars.ui.model.ViewTripDetailModel

/**
 * TripNetworkListToUiTripListConverter -
 *
 * @author naim
 * @version $Id$
 */
class TripNetworkItemToUiTripItemConverter {

    fun convert(tripNetwork: TripModel): ViewTripDetailModel =
            ViewTripDetailModel(
                    id = tripNetwork.id,
                    pilotName = tripNetwork.pilot.name,
                    pilotAvatar = tripNetwork.pilot.avatar,
                    pickupName = tripNetwork.pick_up.name,
                    dropoffName = tripNetwork.drop_off.name,
                    pickupTime = tripNetwork.pick_up.date,
                    dropoffTime = tripNetwork.drop_off.date,
                    distance = tripNetwork.distance.value,
                    distanceUnit = tripNetwork.distance.unit,
                    duration = "5:23:47", // TODO
                    rating = tripNetwork.pilot.rating
            )

}