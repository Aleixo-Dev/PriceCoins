package com.nicolas.pricecoins.data.remoto.mapper

import com.nicolas.pricecoins.data.remoto.model.ApiResponse
import com.nicolas.pricecoins.domain.entities.CoinUSD

object PriceMapper {

    fun ApiResponse.toEntity(): CoinUSD {
        return CoinUSD(
            coinName = this.results.currencies.uSD.name,
            currentValueBuy = this.results.currencies.uSD.buy,
            currentValueSale = this.results.currencies.uSD.sell,
            variation = this.results.currencies.uSD.variation
        )
    }
}