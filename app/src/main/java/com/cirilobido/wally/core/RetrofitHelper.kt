package com.cirilobido.wally.core

import com.cirilobido.wally.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private fun httpLoginInterceptop(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private fun OkHttpClient(): OkHttpClient{
        return OkHttpClient.Builder().addInterceptor(httpLoginInterceptop()).build()
    }

    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.UNSPLASH_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }
}