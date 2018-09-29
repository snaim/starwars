package com.naim.starwars.ui.model

/**
 * TripListItemViewModel -
 *
 * @author naim
 * @version $Id$
 */
data class TripListItemViewModel(
        val id: Int,
        val pilotName: String,
        val pilotAvatar: String,
        val pickupName: String,
        val dropoffName: String
)