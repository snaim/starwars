package com.naim.starwars.domain.model

/**
 * TripListItemViewModel -
 *
 * @author naim
 * @version $Id$
 */
data class TripListItemModel(
        val id: Int,
        val pilotName: String,
        val pilotAvatar: String,
        val pickupName: String,
        val dropoffName: String
)