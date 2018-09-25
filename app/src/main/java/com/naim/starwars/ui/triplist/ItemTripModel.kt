package com.naim.starwars.ui.triplist

import android.support.v7.widget.CardView
import com.airbnb.epoxy.EpoxyModel
import com.bumptech.glide.Glide
import com.naim.starwars.R
import com.naim.starwars.ui.model.UITripListItemModel
import kotlinx.android.synthetic.main.ui_trip_item.view.music_thumbnail
import kotlinx.android.synthetic.main.ui_trip_item.view.title

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
       view.title.text = UITripListItem.pilotName

         Glide.with(view.context)
                .load("https://starwars.chauffeur-prive.com" + UITripListItem.pilotAvatar)
                .into(view.music_thumbnail)
    }
}
