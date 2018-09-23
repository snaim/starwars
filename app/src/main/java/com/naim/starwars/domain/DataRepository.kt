package com.naim.starwars.domain

import com.naim.starwars.data.model.TripModel
import io.reactivex.Observable
import io.reactivex.Single

/**
 * DataRepository -
 *
 * @author naim
 * @version $Id$
 */
interface DataRepository {

    fun getTripList(): Observable<List<TripModel>>

    fun getATrip(id: Int): Single<TripModel>
}