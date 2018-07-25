package com.naim.mymusic.data.network

import com.naim.mymusic.BuildConfig
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
fun buildMusicHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG)
                    HttpLoggingInterceptor.Level.BODY
                else
                    HttpLoggingInterceptor.Level.NONE
            })
            .build()
}

fun buildMusicRetrofit(httpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
            .client(httpClient)
            .baseUrl("http://jsonplaceholder.typicode.com") // TODO : getstring
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}

fun buildMusicApi(retrofit: Retrofit): MusicAPI {
    return retrofit.create(MusicAPI::class.java)
}
