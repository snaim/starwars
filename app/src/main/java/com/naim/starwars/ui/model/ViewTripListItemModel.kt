package com.naim.starwars.ui.model

/**
 * ViewTripListItemModel -
 *
 * @author naim
 * @version $Id$
 */
data class ViewTripListItemModel(
        val id: Int,
        val pilotName: String,
        val pilotAvatar: String,
        val pickupName: String,
        val dropoffName: String
        /*, val rating : int*/ // TODO
)