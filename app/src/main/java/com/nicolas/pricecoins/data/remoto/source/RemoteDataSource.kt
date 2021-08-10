package com.nicolas.pricecoins.data.remoto.source

import com.nicolas.pricecoins.domain.entities.CoinUSD

interface RemoteDataSource {

    suspend fun fetchPrice(): CoinUSD

}