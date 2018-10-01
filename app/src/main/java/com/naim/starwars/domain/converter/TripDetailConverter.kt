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

    fun convert(tripNetwork: TripModel): TripDetailModel {
        val pickupDate = convertToDate(tripNetwork.pick_up.date)
        val dropoffDate = convertToDate(tripNetwork.drop_off.date)

        return TripDetailModel(
                id = tripNetwork.id,
                pilotName = tripNetwork.pilot.name,
                pilotAvatar = tripNetwork.pilot.avatar,
                pickupName = tripNetwork.pick_up.name,
                dropoffName = tripNetwork.drop_off.name,
                pickupDate = pickupDate,
                dropoffDate = dropoffDate,
                distance = tripNetwork.distance.value,
                distanceUnit = tripNetwork.distance.unit,
                duration = getDuration(pickupDate, dropoffDate),
                rating = tripNetwork.pilot.rating
        )
    }

    private fun convertToDate(dateString: String): Date {
        val formatStringToDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        var date: Date
        try {
            date = formatStringToDate.parse(dateString)
        } catch (e: ParseException) {
            throw IllegalArgumentException("Date parsing failed")
        }
        return date
    }

    private fun getDuration(pickupDate: Date, dropoffDate: Date): Long {
        return dropoffDate.time - pickupDate.time
    }

}