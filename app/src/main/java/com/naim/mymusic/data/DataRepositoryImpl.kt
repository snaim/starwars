package com.naim.mymusic.data

import com.naim.mymusic.data.room.model.MusicRoom
import com.naim.mymusic.domain.DataRepository
import io.reactivex.Observable

/**
 * DataRepositoryImpl -
 *
 * @author naim
 * @version $Id$
 */
class DataRepositoryImpl : DataRepository {

    private val music1 = MusicRoom(
            1,
            1,
            "accusamus beatae ad facilis cum similique qui sunt",
            "http://placehold.it/600/92c952",
            "http://placehold.it/150/92c952")
    private val music2 = MusicRoom(
            2,
            1,
            "reprehenderit est deserunt velit ipsam",
            "http://placehold.it/600/771796",
            "http://placehold.it/150/771796")
    private val music3 = MusicRoom(
            3,
            2,
            "officia porro iure quia iusto qui ipsa ut modi",
            "http://placehold.it/600/24f355",
            "http://placehold.it/150/24f355")

    private val listMock: List<MusicRoom> = listOf(music1, music2, music3)

    override fun getMusic(): Observable<List<MusicRoom>> {
        return Observable.just(listMock)
    }
}