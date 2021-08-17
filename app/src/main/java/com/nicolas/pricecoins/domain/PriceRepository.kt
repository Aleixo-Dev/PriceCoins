package com.nicolas.pricecoins.domain

import com.nicolas.pricecoins.domain.entities.CoinUSD
import com.nicolas.pricecoins.extensions.DataState

interface PriceRepository {

    suspend fun fetchCoinUsd(): DataState<CoinUSD>

}