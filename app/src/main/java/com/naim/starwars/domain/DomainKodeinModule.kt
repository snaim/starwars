package com.naim.starwars.domain

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.github.salomonbrys.kodein.singleton
import com.naim.starwars.data.DataRepositoryImpl
import com.naim.starwars.domain.converter.TripNetworkToUiTripConverter
import com.naim.starwars.domain.interactor.GetTripListUseCase

/**
 * DomainKodeinModule -
 *
 * @author naim
 * @version $Id$
 */
val domainKodeinModule = Kodein.Module {

    bind<DataRepository>() with singleton { DataRepositoryImpl(instance()) }

    bind<TripNetworkToUiTripConverter>() with provider { TripNetworkToUiTripConverter() }

    bind<GetTripListUseCase>() with provider { GetTripListUseCase(instance(), instance()) }
}
