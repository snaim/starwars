package com.naim.starwars.ui.model

/**
 * ViewTripDetailModel -
 *
 * @author naim
 * @version $Id$
 */
data class ViewTripDetailModel(
        val id: Int,
        val pilotName: String,
        val pilotAvatar: String,
        val pickupName: String,
        val dropoffName: String,
        val pickupTime: String, // TODO ?
        val dropoffTime: String, // TODO ?
        val distance: Long,
        val distanceUnit: String,
        val duration: String, // TODO
        val rating: Float
)