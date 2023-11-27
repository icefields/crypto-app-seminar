package com.plcoding.cryptocurrencyappyt.domain.repository

import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetail

/**
 * this is just the definition, and it's all the use case needs to know
 * very useful for testing, instead of using the actual API calls use mocked data data that
 * simulates the behaviour of the api
 */
interface CoinRepository {
    suspend fun getCoins(): List<Coin>
    suspend fun getCoinById(coinId: String): CoinDetail
}
