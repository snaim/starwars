package com.naim.mymusic.data.room

import com.naim.mymusic.data.room.model.MusicRoom
import io.reactivex.Flowable

/**
 * MyDatabase -
 *
 * @author naim
 * @version $Id$
 */
interface MyDatabase {

    fun getAll(): Flowable<List<MusicRoom>>
}