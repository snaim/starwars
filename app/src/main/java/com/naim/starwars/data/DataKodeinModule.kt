package com.naim.starwars.data

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.naim.starwars.data.network.StarwarsAPI
import com.naim.starwars.data.network.buildMusicApi
import com.naim.starwars.data.network.buildMusicHttpClient
import com.naim.starwars.data.network.buildMusicRetrofit
import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 * dataKodeinModule -
 *
 * @author naim
 * @version $Id$
 */
val dataKodeinModule = Kodein.Module {

    bind<OkHttpClient>() with singleton { buildMusicHttpClient() }

    bind<Retrofit>() with singleton { buildMusicRetrofit(instance()) }

    bind<StarwarsAPI>() with singleton { buildMusicApi(instance()) }
}