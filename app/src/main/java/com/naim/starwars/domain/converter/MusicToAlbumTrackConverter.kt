package com.naim.starwars.domain.converter

import com.naim.starwars.ui.model.UITripListItemModel

/**
 * MusicToAlbumTrackConverter -
 *
 * @author naim
 * @version $Id$
 */
class MusicToAlbumTrackConverter {

    fun convert(list: List<UITripListItemModel>): Map<Int, List<UITripListItemModel>> = list.groupBy { it.id }
}