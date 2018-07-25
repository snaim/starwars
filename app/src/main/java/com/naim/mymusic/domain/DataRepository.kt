package com.naim.mymusic.domain

import com.naim.mymusic.data.room.model.MusicRoom
import io.reactivex.Observable

/**
 * DataRepository -
 *
 * @author naim
 * @version $Id$
 */
interface DataRepository {

    fun getMusic(): Observable<List<MusicRoom>>

    fun saveMusic(list: List<MusicRoom>)
}