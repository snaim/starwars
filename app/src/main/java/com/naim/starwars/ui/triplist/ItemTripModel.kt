package com.naim.starwars.ui.triplist

import android.support.v7.widget.CardView
import com.airbnb.epoxy.EpoxyModel
import com.bumptech.glide.Glide
import com.naim.starwars.R
import com.naim.starwars.ui.model.ViewTripListItemModel
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
class ItemTripModel(private val ViewTripListItem: ViewTripListItemModel,
                    private val clickListener: OnClickListener)
    : EpoxyModel<CardView>() {

    override fun getDefaultLayout(): Int {
        return R.layout.ui_trip_item
    }

    override fun bind(view: CardView) {
        view.pilot.text = ViewTripListItem.pilotName

        view.pickup.text = ViewTripListItem.pickupName
        view.dropoff.text = ViewTripListItem.dropoffName

        view.setOnClickListener { clickListener.onClick(ViewTripListItem.id) }

        Glide.with(view.context)
                // TODO
                .load(view.context.resources.getString(R.string.base_url) + ViewTripListItem.pilotAvatar)
                .into(view.pilot_avatar)
    }

    interface OnClickListener {
        fun onClick(id: Int)
    }
}
