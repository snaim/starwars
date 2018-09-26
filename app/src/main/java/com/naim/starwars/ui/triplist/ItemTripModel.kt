package com.naim.starwars.ui.triplist

import android.support.v7.widget.CardView
import com.airbnb.epoxy.EpoxyModel
import com.bumptech.glide.Glide
import com.naim.starwars.R
import com.naim.starwars.ui.model.UITripListItemModel
import kotlinx.android.synthetic.main.ui_trip_item.view.dropoff
import kotlinx.android.synthetic.main.ui_trip_item.view.pickup
import kotlinx.android.synthetic.main.ui_trip_item.view.pilot
import kotlinx.android.synthetic.main.ui_trip_item.view.pilot_avatar

/**
 * ItemPhoneModel -
 *
 * @author naim
 * @version $Id$
 */
class ItemTripModel(private val UITripListItem: UITripListItemModel) : EpoxyModel<CardView>() {

    override fun getDefaultLayout(): Int {
        return R.layout.ui_trip_item
    }

    override fun bind(view: CardView) {
        view.pilot.text = UITripListItem.pilotName

        view.pickup.text = UITripListItem.pickupName
        view.dropoff.text = UITripListItem.dropoffName

        Glide.with(view.context)
                // TODO
                .load(view.context.resources.getString(R.string.base_url) + UITripListItem.pilotAvatar)
                .into(view.pilot_avatar)
    }
}
