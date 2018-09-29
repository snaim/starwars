package com.naim.starwars.ui.mapper

import com.naim.starwars.R
import com.naim.starwars.domain.model.TripDetailModel
import com.naim.starwars.ui.model.TripDetailViewModel
import java.text.SimpleDateFormat
import java.util.*

class TripDetailMapper {

    fun transform(trip: TripDetailModel): TripDetailViewModel {
        val ratingRounded = getRatingRounded(trip.rating)
        return TripDetailViewModel(
                id = trip.id,
                pilotName = trip.pilotName,
                pilotAvatar = getPilotAvatarUrl(trip.pilotAvatar),
                departureName = trip.pickupName,
                departureTime = getFormattedTime(trip.pickupDate),
                arrivalName = trip.dropoffName,
                arrivalTime = getFormattedTime(trip.dropoffDate),
                distanceValue = getFormattedDistance(trip.distance),
                distanceUnit = trip.distanceUnit,
                duration = getFormattedDuration(trip.duration),
                rating = ratingRounded,
                starListResId = getStarListResIt(ratingRounded)
        )
    }

    private fun getStarListResIt(rating: Int): List<Int> {
        val list = mutableListOf<Int>()
        for (i in 1..rating) {
            list.add(R.drawable.star_filled)
        }
        for (i in rating..4) {
            list.add(R.drawable.star_empty)
        }
        return list
    }

    private fun getRatingRounded(rating: Float): Int = Math.round(rating)

    private fun getPilotAvatarUrl(avatar: String): String {
        return "https://starwars.chauffeur-prive.com" + avatar// TODO : resources.getString(R.string.base_url)
    }

    private fun getFormattedDuration(duration: Long): String {
        val formatterDuration = SimpleDateFormat("h:mm:ss") // TODO : si plus d'un jour
        return formatterDuration.format(duration)
    }

    private fun getFormattedDistance(distance: Long): String {
        return String.format("%,d", distance)
    }

    private fun getFormattedTime(datetime: Date): String {
        val formatDateToDisplayTime = SimpleDateFormat("h:mm a") // TODO
        return formatDateToDisplayTime.format(datetime)
    }

}