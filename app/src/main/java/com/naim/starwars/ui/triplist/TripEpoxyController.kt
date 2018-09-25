package com.naim.starwars.ui.triplist

import com.airbnb.epoxy.TypedEpoxyController
import com.naim.starwars.ui.model.UITripListItemModel

/**
 * TripEpoxyController -
 *
 * @author naim
 * @version $Id$
 */

class TripEpoxyController : TypedEpoxyController<List<UITripListItemModel>>() {

    override fun buildModels(tripListItems: List<UITripListItemModel>) {

        tripListItems.forEach {
            ItemTripModel(it)
                    .id(it.hashCode())
                    .addTo(this)
        }

    }
}