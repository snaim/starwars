package com.naim.starwars.ui.musiclist

import android.support.v7.widget.CardView
import com.airbnb.epoxy.EpoxyModel
import com.bumptech.glide.Glide
import com.naim.starwars.R
import com.naim.starwars.ui.model.MusicModel
import kotlinx.android.synthetic.main.ui_music_item.view.music_thumbnail
import kotlinx.android.synthetic.main.ui_music_item.view.title

/**
 * ItemPhoneModel -
 *
 * @author naim
 * @version $Id$
 */
class ItemMusicModel(private val music: MusicModel) : EpoxyModel<CardView>() {

    override fun getDefaultLayout(): Int {
        return R.layout.ui_music_item
    }

    override fun bind(view: CardView) {
        view.title.text = music.title

        Glide.with(view.context)
                .load(music.thumbnailUrl)
                .into(view.music_thumbnail)
    }
}
