package com.naim.starwars.domain.converter

import com.naim.starwars.ui.model.MusicModel

/**
 * MusicToAlbumTrackConverter -
 *
 * @author naim
 * @version $Id$
 */
class MusicToAlbumTrackConverter {

    fun convert(list: List<MusicModel>): Map<Int, List<MusicModel>> = list.groupBy { it.albumId }
}