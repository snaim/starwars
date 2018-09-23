package com.naim.starwars.data

import com.naim.starwars.data.model.TripModel
import com.naim.starwars.data.network.StarwarsAPI
import com.naim.starwars.domain.DataRepository
import io.reactivex.Observable
import io.reactivex.Single

/**
 * DataRepositoryImpl -
 *
 * @author naim
 * @version $Id$
 */
class DataRepositoryImpl(private val starwarsAPI: StarwarsAPI) : DataRepository {

    override fun getTripList(): Observable<List<TripModel>> = starwarsAPI.getTripList()

    override fun getATrip(id: Int): Single<TripModel> = starwarsAPI.getATrip(id)


}