package com.naim.starwars.ui

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
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
            provider { TripListPresenter(instance(), instance(), instance()) }
}

