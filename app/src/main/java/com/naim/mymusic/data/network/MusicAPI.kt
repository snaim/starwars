package com.naim.mymusic.data.network

import com.naim.mymusic.data.room.model.MusicRoom
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * MusicAPI -
 *
 * @author naim
 * @version $Id$
 */
interface MusicAPI {

    @GET("photos")
    fun load(): Observable<List<MusicRoom>>
}