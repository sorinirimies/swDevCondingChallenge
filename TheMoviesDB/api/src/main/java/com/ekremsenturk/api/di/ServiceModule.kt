package com.ekremsenturk.api.di

import com.ekremsenturk.api.ApiService
import com.ekremsenturk.api.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val SERVER_URL = "https://api.themoviedb.org/"

val serviceModule = module {
    single { buildOkhttpClient() }
    single { buildRetrofitClient(get()) }
    single { buildApiService(get()) }
}

private fun buildRetrofitClient(okhttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(SERVER_URL)
        .client(okhttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun buildOkhttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            }
        }
        .build()
}

private fun buildApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}