package com.naim.starwars.domain.converter

import com.naim.starwars.data.model.TripModel
import com.naim.starwars.ui.model.UITripListItemModel

/**
 * MusicRoomToMusicModelConverter -
 *
 * @author naim
 * @version $Id$
 */
class MusicRoomToMusicModelConverter {

    fun convert(listMusicRoom: List<TripModel>): List<UITripListItemModel> {
        val musicModelList = mutableListOf<UITripListItemModel>()
       /* listMusicRoom.forEach {
            musicModelList.add( UITripListItemModel(
                    id = it.id))
        }*/
        return musicModelList
    }
}