package com.naim.starwars.data.room

import com.naim.starwars.data.room.model.MusicRoom
import io.reactivex.Flowable

/**
 * MusicDatabaseImpl -
 *
 * @author naim
 * @version $Id$
 */
class MusicDatabaseImpl(database: Database) : MusicDatabase {

    private val musicDao = database.musicDao()

    override fun getAll(): Flowable<List<MusicRoom>> = this.musicDao.getAll()

    override fun insertAll(list: List<MusicRoom>) = this.musicDao.insertAll(list)
}