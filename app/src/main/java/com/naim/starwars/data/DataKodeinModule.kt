package com.naim.starwars.data

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.naim.starwars.data.network.StarwarsAPI
import com.naim.starwars.data.network.buildStarwarsApi
import com.naim.starwars.data.network.buildStarwarsHttpClient
import com.naim.starwars.data.network.buildStarwarsRetrofit
import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 * dataKodeinModule -
 *
 * @author naim
 * @version $Id$
 */
val dataKodeinModule = Kodein.Module {

    bind<OkHttpClient>() with singleton { buildStarwarsHttpClient() }

    bind<Retrofit>() with singleton { buildStarwarsRetrofit(instance()) }

    bind<StarwarsAPI>() with singleton { buildStarwarsApi(instance()) }
}