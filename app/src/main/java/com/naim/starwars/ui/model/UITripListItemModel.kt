package com.naim.starwars.ui.model

/**
 * UITripListItemModel -
 *
 * @author naim
 * @version $Id$
 */
data class UITripListItemModel(
        val id: Int,
        val pilotName: String,
        val pilotAvatar: String,
        val pickupName: String,
        val dropoffName: String
        /*, val rating : int*/
)