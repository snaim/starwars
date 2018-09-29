package com.naim.starwars.domain

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.github.salomonbrys.kodein.singleton
import com.naim.starwars.data.DataRepositoryImpl
import com.naim.starwars.domain.converter.TripDetailConverter
import com.naim.starwars.domain.converter.TripListConverter
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

    bind<TripListConverter>() with provider { TripListConverter() }
    bind<TripDetailConverter>() with provider { TripDetailConverter() }

    bind<GetTripListUseCase>() with provider { GetTripListUseCase(instance(), instance()) }
    bind<GetATripUseCase>() with provider { GetATripUseCase(instance(), instance()) }
}
