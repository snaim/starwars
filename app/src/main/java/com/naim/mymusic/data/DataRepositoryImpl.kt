package com.naim.mymusic.data

import com.naim.mymusic.data.network.MusicAPI
import com.naim.mymusic.data.room.MyDatabase
import com.naim.mymusic.data.room.model.MusicRoom
import com.naim.mymusic.domain.DataRepository
import io.reactivex.Observable

/**
 * DataRepositoryImpl -
 *
 * @author naim
 * @version $Id$
 */
class DataRepositoryImpl(private val myDatabase: MyDatabase, private val musicAPI: MusicAPI)
    : DataRepository {

    // TODO : here get data from network if not exist in database and save it in
    // else get data from database
    override fun getMusic(): Observable<List<MusicRoom>> {
//        myDatabase.getAll()
        return musicAPI.load()
    }
}