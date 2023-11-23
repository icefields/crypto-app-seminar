package com.plcoding.cryptocurrencyappyt.di

import com.plcoding.cryptocurrencyappyt.common.Constants
import com.plcoding.cryptocurrencyappyt.data.remote.CoinPaprikaApi
import com.plcoding.cryptocurrencyappyt.data.repository.CoinRepositoryImpl
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * dependency injections will help making our dependencies replaceable
 */
@Module
@InstallIn(SingletonComponent::class) // means this module will live as long as the application
object AppModule {
    @Provides
    @Singleton // makes sure we only have a single instance of this object
    fun providePaprikaApi(): CoinPaprikaApi = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CoinPaprikaApi::class.java)

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository = CoinRepositoryImpl(api)
}
