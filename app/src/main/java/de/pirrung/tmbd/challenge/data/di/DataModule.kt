package de.pirrung.tmbd.challenge.data.di

import de.pirrung.tmbd.challenge.BuildConfig
import de.pirrung.tmbd.challenge.data.remote.TMDBApi
import de.pirrung.tmbd.challenge.data.repository.TMDBRepositoryImpl
import de.pirrung.tmbd.challenge.domain.repository.TMDBRepository
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single { provideHttpClient() }
    single { provideTMDBApi(get()) }
    single<TMDBRepository> { TMDBRepositoryImpl(get()) }
}

private fun provideHttpClient(): OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .addInterceptor { chain ->
            val originalRequest = chain.request()
            val originalHttpUrl: HttpUrl = originalRequest.url

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
                .build()
            val request = originalRequest.newBuilder()
                .url(url)
                .build()
            chain.proceed(request)
        }
        .build()

private fun provideTMDBApi(client: OkHttpClient): TMDBApi =
    Retrofit.Builder()
        .baseUrl(TMDBApi.BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(TMDBApi::class.java)