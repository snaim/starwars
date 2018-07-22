package com.naim.mymusic.data.room

import com.naim.mymusic.data.room.model.MusicRoom
import io.reactivex.Flowable

/**
 * MyDatabaseImpl -
 *
 * @author naim
 * @version $Id$
 */
class MyDatabaseImpl(database: Database) : MyDatabase {

    private val musicDao = database.musicDao()

    override fun getAll(): Flowable<List<MusicRoom>> =
            this.musicDao.getAll()
}