package com.naim.starwars.domain

import com.naim.starwars.data.room.model.MusicRoom
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