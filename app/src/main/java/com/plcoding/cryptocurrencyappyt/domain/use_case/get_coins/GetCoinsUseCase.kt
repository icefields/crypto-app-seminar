package com.plcoding.cryptocurrencyappyt.domain.use_case.get_coins

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoin
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

/**
 * use cases should only have one public function, the function to execute the use case, in this
 * case get the coins. there is only feature that we expose to the view model that the class should
 * contain
 */
class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    /**
     * with this is possible to call the use case as a function
     * We return a flow because we want to emit multiple values over a period of time, we want to
     * emit Loading, Successful with data or Error.
     */
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins()
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage))
        } catch (e: IOException) {
            // happens when the api call cannot reach the server
            emit(Resource.Error(e.localizedMessage))
        }
    }
}
