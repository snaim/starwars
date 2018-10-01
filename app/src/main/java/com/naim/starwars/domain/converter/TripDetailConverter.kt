package com.naim.starwars.domain.converter

import com.naim.starwars.data.model.TripModel
import com.naim.starwars.domain.model.TripDetailModel
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * TripListConverter -
 *
 * @author naim
 * @version $Id$
 */
class TripDetailConverter {

    fun convert(tripNetwork: TripModel): TripDetailModel =
            TripDetailModel(
                    id = tripNetwork.id,
                    pilotName = tripNetwork.pilot.name,
                    pilotAvatar = tripNetwork.pilot.avatar,
                    pickupName = tripNetwork.pick_up.name,
                    dropoffName = tripNetwork.drop_off.name,
                    pickupDate = convertToDate(tripNetwork.pick_up.date),
                    dropoffDate = convertToDate(tripNetwork.drop_off.date),
                    distance = tripNetwork.distance.value,
                    distanceUnit = tripNetwork.distance.unit,
                    duration = tripNetwork.duration,
                    rating = tripNetwork.pilot.rating
            )

    private fun convertToDate(dateString: String): Date {
        val formatStringToDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val date: Date
        try {
            date = formatStringToDate.parse(dateString)
        } catch (e: ParseException) {
            throw IllegalArgumentException("Date parsing failed")
        }
        return date
    }

}