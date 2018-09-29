package com.naim.starwars.domain.model

import java.util.Date

/**
 * TripDetailModel -
 *
 * @author naim
 * @version $Id$
 */
data class TripDetailModel(
        val id: Int,
        val pilotName: String,
        val pilotAvatar: String,
        val pickupName: String,
        val dropoffName: String,
        val pickupDate: Date,
        val dropoffDate: Date,
        val distance: Long,
        val distanceUnit: String,
        val duration: Long,
        val rating: Float
)