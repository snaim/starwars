package com.naim.starwars.data

import android.arch.persistence.room.Room
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.naim.starwars.data.network.MusicAPI
import com.naim.starwars.data.network.buildMusicApi
import com.naim.starwars.data.network.buildMusicHttpClient
import com.naim.starwars.data.network.buildMusicRetrofit
import com.naim.starwars.data.room.Database
import com.naim.starwars.data.room.MusicDatabase
import com.naim.starwars.data.room.MusicDatabaseImpl
import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 * dataKodeinModule -
 *
 * @author naim
 * @version $Id$
 */
val dataKodeinModule = Kodein.Module {
    // Database
    bind<Database>() with singleton {
        Room.databaseBuilder(instance(), Database::class.java,
                Database.DATABASE_NAME)
                .build()
    }
    bind<MusicDatabase>() with singleton { MusicDatabaseImpl(instance()) }

    // Network
    bind<OkHttpClient>() with singleton { buildMusicHttpClient() }

    bind<Retrofit>() with singleton { buildMusicRetrofit(instance()) }

    bind<MusicAPI>() with singleton { buildMusicApi(instance()) }
}