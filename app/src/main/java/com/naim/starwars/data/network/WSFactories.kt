package com.naim.starwars.data.network

import com.naim.starwars.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * WSFactories -
 *
 * @author naim
 * @version $Id$
 */
fun buildStarwarsHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG)
                    HttpLoggingInterceptor.Level.BODY
                else
                    HttpLoggingInterceptor.Level.NONE
            })
            .build()
}

fun buildStarwarsRetrofit(httpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
            .client(httpClient)
            .baseUrl("https://starwars.chauffeur-prive.com")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}

fun buildStarwarsApi(retrofit: Retrofit): StarwarsAPI {
    return retrofit.create(StarwarsAPI::class.java)
}
