package com.naim.mymusic.ui.musiclist

import android.support.v7.widget.CardView
import com.airbnb.epoxy.EpoxyModel
import com.naim.mymusic.R
import com.naim.mymusic.ui.model.MusicModel
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
    }
}
