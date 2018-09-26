package com.naim.starwars.data.network

import com.naim.starwars.data.model.TripModel
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

/**
 * StarwarsAPI -
 *
 * @author naim
 * @version $Id$
 */
interface StarwarsAPI {

    @Headers("Accept: application/json") // TODO
    @GET("trips")
    fun getTripList(): Observable<List<TripModel>>

    @GET("trips/{id}")
    fun getATrip(@Path("id") customerId: Int): Single<TripModel>
}