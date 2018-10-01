package com.naim.starwars.ui

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.factory
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.github.salomonbrys.kodein.singleton
import com.naim.starwars.ui.mapper.TripDetailMapper
import com.naim.starwars.ui.mapper.TripListMapper
import com.naim.starwars.ui.tripdetail.TripDetailContract
import com.naim.starwars.ui.tripdetail.TripDetailPresenter
import com.naim.starwars.ui.triplist.TripListContract
import com.naim.starwars.ui.triplist.TripListPresenter

/**
 * uiKodeinModule -
 *
 * @author naim
 * @version $Id$
 */
val uiKodeinModule = Kodein.Module {

    bind<TripListContract.Presenter>() with
            provider { TripListPresenter(instance(), instance(), instance(), instance()) }

    bind<TripDetailContract.Presenter>() with factory { tripId: Int ->
        TripDetailPresenter(instance(), instance(), instance(), instance(), tripId)
    }

    bind<TripDetailMapper>() with singleton { TripDetailMapper(instance()) }
    bind<TripListMapper>() with singleton { TripListMapper(instance()) }
}

