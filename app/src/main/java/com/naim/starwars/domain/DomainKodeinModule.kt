package com.naim.starwars.domain

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.github.salomonbrys.kodein.singleton
import com.naim.starwars.data.DataRepositoryImpl
import com.naim.starwars.domain.converter.TripNetworkItemToUiTripItemConverter
import com.naim.starwars.domain.converter.TripNetworkListToUiTripListConverter
import com.naim.starwars.domain.interactor.GetATripUseCase
import com.naim.starwars.domain.interactor.GetTripListUseCase

/**
 * DomainKodeinModule -
 *
 * @author naim
 * @version $Id$
 */
val domainKodeinModule = Kodein.Module {

    bind<DataRepository>() with singleton { DataRepositoryImpl(instance()) }

    bind<TripNetworkListToUiTripListConverter>() with provider { TripNetworkListToUiTripListConverter() }
    bind<TripNetworkItemToUiTripItemConverter>() with provider { TripNetworkItemToUiTripItemConverter() }

    bind<GetTripListUseCase>() with provider { GetTripListUseCase(instance(), instance()) }
    bind<GetATripUseCase>() with provider { GetATripUseCase(instance(), instance()) }
}
