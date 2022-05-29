package com.ekremsenturk.api.di

import com.ekremsenturk.api.ApiService
import com.ekremsenturk.api.BuildConfig
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val SERVER_URL = "https://api.themoviedb.org/"
private const val API_KEY = "37023a75e7f3882153de60dd787b59de"

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
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }
        }
        .addInterceptor { chain ->
            //This interceptor adds the api key as query parameter to every request
            val originalRequest = chain.request()
            val originalHttpUrl: HttpUrl = originalRequest.url

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .build()
            val request = originalRequest.newBuilder()
                .url(url)
                .build()
            chain.proceed(request)
        }
        .build()
}

private fun buildApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}