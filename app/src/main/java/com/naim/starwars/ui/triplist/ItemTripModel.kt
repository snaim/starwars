package com.naim.starwars.ui.triplist

import android.support.v7.widget.CardView
import com.airbnb.epoxy.EpoxyModel
import com.bumptech.glide.Glide
import com.naim.starwars.R
import com.naim.starwars.ui.model.TripListItemViewModel
import kotlinx.android.synthetic.main.ui_trip_item.view.dropoff
import kotlinx.android.synthetic.main.ui_trip_item.view.pickup
import kotlinx.android.synthetic.main.ui_trip_item.view.pilot
import kotlinx.android.synthetic.main.ui_trip_item.view.pilot_avatar

/**
 * ItemTripModel -
 *
 * @author naim
 * @version $Id$
 */
class ItemTripModel(
        private val trip: TripListItemViewModel,
        private val clickListener: OnClickListener
) : EpoxyModel<CardView>() {

    override fun getDefaultLayout(): Int {
        return R.layout.ui_trip_item
    }

    override fun bind(view: CardView) {
        view.pilot.text = trip.pilotName

        view.pickup.text = trip.pickupName
        view.dropoff.text = trip.dropoffName

        view.setOnClickListener { clickListener.onClick(trip.id) }

        Glide.with(view.context)
                .load(trip.pilotAvatar)
                .into(view.pilot_avatar)
    }

    interface OnClickListener {
        fun onClick(id: Int)
    }
}
