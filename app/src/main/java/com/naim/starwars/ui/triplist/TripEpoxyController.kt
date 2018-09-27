package com.naim.starwars.ui.triplist

import com.airbnb.epoxy.TypedEpoxyController
import com.naim.starwars.ui.model.ViewTripListItemModel

/**
 * TripEpoxyController -
 *
 * @author naim
 * @version $Id$
 */

class TripEpoxyController(private val listener: ItemTripModel.OnClickListener)
    : TypedEpoxyController<List<ViewTripListItemModel>>() {

    override fun buildModels(tripListItems: List<ViewTripListItemModel>) {

        tripListItems.forEach {
            ItemTripModel(it, listener)
                    .id(it.hashCode())
                    .addTo(this)
        }

    }
}