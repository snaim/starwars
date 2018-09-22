package com.naim.starwars.ui

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.naim.starwars.ui.musiclist.MusicListContract
import com.naim.starwars.ui.musiclist.MusicListPresenter

/**
 * uiKodeinModule -
 *
 * @author naim
 * @version $Id$
 */
val uiKodeinModule = Kodein.Module {
    bind<MusicListContract.Presenter>() with
            provider { MusicListPresenter(instance(), instance(), instance(), instance()) }
}

