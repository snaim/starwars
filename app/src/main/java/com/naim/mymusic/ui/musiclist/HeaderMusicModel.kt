package com.naim.mymusic.ui.musiclist

import android.support.constraint.ConstraintLayout
import com.airbnb.epoxy.EpoxyModel
import com.naim.mymusic.R
import kotlinx.android.synthetic.main.ui_music_header.view.album_title

/**
 * ItemPhoneModel -
 *
 * @author naim
 * @version $Id$
 */
class HeaderMusicModel(private val idAlbum: Int) : EpoxyModel<ConstraintLayout>() {

    override fun getDefaultLayout(): Int {
        return R.layout.ui_music_header
    }

    override fun bind(view: ConstraintLayout) {
        view.album_title.text = idAlbum.toString()
    }
}
