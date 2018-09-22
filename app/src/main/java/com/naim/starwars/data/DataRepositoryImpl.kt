package com.naim.starwars.data

import com.naim.starwars.data.room.MusicDatabase
import com.naim.starwars.data.room.model.MusicRoom
import com.naim.starwars.domain.DataRepository
import io.reactivex.Observable

/**
 * DataRepositoryImpl -
 *
 * @author naim
 * @version $Id$
 */
class DataRepositoryImpl(private val musicDatabase: MusicDatabase) : DataRepository {

    override fun getMusic(): Observable<List<MusicRoom>> = musicDatabase.getAll().toObservable()

    override fun saveMusic(list: List<MusicRoom>) = musicDatabase.insertAll(list)
}