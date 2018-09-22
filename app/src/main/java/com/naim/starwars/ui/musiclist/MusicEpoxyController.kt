package com.naim.starwars.ui.musiclist

import com.airbnb.epoxy.TypedEpoxyController
import com.naim.starwars.ui.model.MusicModel

/**
 * MusicEpoxyController -
 *
 * @author naim
 * @version $Id$
 */

class MusicEpoxyController : TypedEpoxyController<Map<Int, List<MusicModel>>>() {

    override fun buildModels(musics: Map<Int, List<MusicModel>>) {

        for ((idAlbum, musicList) in musics) {
            // Header - Album
            HeaderMusicModel(idAlbum)
                    .id(idAlbum)
                    .addTo(this)

            musicList.forEach {
                // Music
                ItemMusicModel(it)
                        .id(it.hashCode())
                        .addTo(this)
            }
        }
    }
}