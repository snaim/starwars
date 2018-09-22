package com.naim.starwars.data.room

import com.naim.starwars.data.room.model.MusicRoom
import io.reactivex.Flowable

/**
 * MusicDatabase -
 *
 * @author naim
 * @version $Id$
 */
interface MusicDatabase {

    fun getAll(): Flowable<List<MusicRoom>>

    fun insertAll(list : List<MusicRoom>)
}