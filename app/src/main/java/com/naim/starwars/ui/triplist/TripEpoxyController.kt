package com.naim.starwars.ui.triplist

import com.airbnb.epoxy.TypedEpoxyController
import com.naim.starwars.ui.model.TripListItemViewModel

/**
 * TripEpoxyController -
 *
 * @author naim
 * @version $Id$
 */

class TripEpoxyController(private val listener: ItemTripModel.OnClickListener) :
        TypedEpoxyController<List<TripListItemViewModel>>() {

    override fun buildModels(tripList: List<TripListItemViewModel>) {

        tripList.forEach {
            ItemTripModel(it, listener)
                    .id(it.hashCode())
                    .addTo(this)
        }

    }
}