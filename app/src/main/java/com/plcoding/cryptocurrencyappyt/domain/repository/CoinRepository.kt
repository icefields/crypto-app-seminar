package com.plcoding.cryptocurrencyappyt.domain.repository

import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDto

/**
 * this is just the definition, and it's all the use case needs to know
 * very useful for testing, instead of using the actual API calls use mocked data data that
 * simulates the behaviour of the api
 */
interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}
