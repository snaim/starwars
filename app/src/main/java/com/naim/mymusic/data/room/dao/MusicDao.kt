package com.naim.mymusic.data.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(musicList: List<MusicRoom>)
}