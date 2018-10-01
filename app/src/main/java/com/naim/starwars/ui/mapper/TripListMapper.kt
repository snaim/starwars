package com.naim.starwars.ui.mapper

import android.content.Context
import com.naim.starwars.R
import com.naim.starwars.domain.model.TripListItemModel
import com.naim.starwars.ui.model.TripListItemViewModel

class TripListMapper(private val context: Context) {

    fun transform(tripList: List<TripListItemModel>): List<TripListItemViewModel> {
        return tripList.map {
            TripListItemViewModel(
                    id = it.id,
                    pilotName = it.pilotName,
                    pilotAvatar = getPilotAvatarUrl(it.pilotAvatar),
                    pickupName = it.pickupName,
                    dropoffName = it.dropoffName
            )
        }
    }

    private fun getPilotAvatarUrl(avatar: String): String {
        return context.getString(R.string.base_url) + avatar
    }
}