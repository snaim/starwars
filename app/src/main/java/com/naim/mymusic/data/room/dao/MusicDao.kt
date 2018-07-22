package com.naim.mymusic.data.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.naim.mymusic.data.room.model.MusicRoom
import io.reactivex.Flowable

/**
 * MusicDao -
 *
 * @author naim
 * @version $Id$
 */
@Dao
interface MusicDao {

    @Query("select * from Music")
    fun getAll(): Flowable<List<MusicRoom>>
}