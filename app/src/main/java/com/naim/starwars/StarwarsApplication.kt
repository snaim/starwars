package com.naim.starwars

import android.app.Activity
import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.android.androidActivityScope
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.lazy
import com.github.salomonbrys.kodein.provider
import com.github.salomonbrys.kodein.scopedSingleton
import com.github.salomonbrys.kodein.with
import com.naim.starwars.data.dataKodeinModule
import com.naim.starwars.domain.domainKodeinModule
import com.naim.starwars.ui.AppFragmentNavigator
import com.naim.starwars.ui.Navigator
import com.naim.starwars.ui.uiKodeinModule

/**
 * StarwarsApplication -
 *
 * @author naim
 * @version $Id$
 */
class StarwarsApplication : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        import(uiKodeinModule)
        import(domainKodeinModule)
        import(dataKodeinModule)

        /* Container View ID is injected using Kodein Constants [https://salomonbrys.github.io/Kodein/#_constant_binding]
        * AppFragmentNavigator is bound to the Activity scope because it needs to be rebuilt every time the Activity is recreated,
        * because it depends on the Activity FragmentManager and Context
        * */
        bind<AppFragmentNavigator>() with scopedSingleton(androidActivityScope) { AppFragmentNavigator(instance(), instance(), instance("FRAGMENT_CONTAINER_ID")) }

        /* Will bind the Navigator interface to the same AppFragmentNavigator instance as above,
         * because of singleton keyword. with(instance<Activity>()) is needed because of the Activity Scope
        */
        bind<Navigator>() with provider { with(instance<Activity>()).instance<AppFragmentNavigator>() }
    }
}
