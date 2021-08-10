package com.nicolas.pricecoins.di

import com.nicolas.pricecoins.data.remoto.api.ServiceApi
import com.nicolas.pricecoins.data.remoto.source.RemoteDataSource
import com.nicolas.pricecoins.data.remoto.source.RemoteDataSourceImpl
import com.nicolas.pricecoins.domain.PriceRepository
import com.nicolas.pricecoins.domain.PriceRepositoryImpl
import com.nicolas.pricecoins.domain.usecase.GetPriceUsdUseCase
import com.nicolas.pricecoins.extensions.Constants
import com.nicolas.pricecoins.presenter.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val initializationApi = module {

    single { provideRetrofitService() }
    single { provideApiService(get()) }
    single { provideOkHttp() }
}

val instanceApplication = module {

    factory { GetPriceUsdUseCase(repository = get()) }

    factory<RemoteDataSource> {
        RemoteDataSourceImpl(service = get())
    }

    factory<PriceRepository> {
        PriceRepositoryImpl(remote = get())
    }

    viewModel {
        MainViewModel(
            getPriceUsdUseCase = get()
        )
    }
}

private fun provideRetrofitService(): Retrofit =
    Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(provideOkHttp())
        .build()

private fun provideApiService(retrofit: Retrofit): ServiceApi =
    retrofit.create(ServiceApi::class.java)

private fun provideOkHttp(): OkHttpClient {

    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    return OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .build()
}
