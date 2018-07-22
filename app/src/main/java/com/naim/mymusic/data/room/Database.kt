package com.naim.mymusic.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.naim.mymusic.data.room.dao.MusicDao
import com.naim.mymusic.data.room.model.MusicRoom

/**
 * Database -
 *
 * @author naim
 * @version $Id$
 */
@Database(entities = [(MusicRoom::class)], version = 1)
abstract class Database : RoomDatabase() {
    companion object {
        val DATABASE_NAME = "mymusic-db"
    }

    abstract fun musicDao(): MusicDao
}