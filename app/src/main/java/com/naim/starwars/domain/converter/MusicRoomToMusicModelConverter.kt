package com.naim.starwars.domain.converter

import com.naim.starwars.data.room.model.MusicRoom
import com.naim.starwars.ui.model.MusicModel

/**
 * MusicRoomToMusicModelConverter -
 *
 * @author naim
 * @version $Id$
 */
class MusicRoomToMusicModelConverter {

    fun convert(listMusicRoom: List<MusicRoom>): List<MusicModel> {
        val musicModelList = mutableListOf<MusicModel>()
        listMusicRoom.forEach {
            musicModelList.add( MusicModel(
                    id = it.id,
                    albumId = it.albumId,
                    title = it.title,
                    url = it.url,
                    thumbnailUrl = it.thumbnailUrl))
        }
        return musicModelList
    }
}