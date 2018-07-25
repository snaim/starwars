package com.naim.mymusic.data.room

import com.naim.mymusic.data.room.model.MusicRoom
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