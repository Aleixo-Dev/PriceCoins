package com.nicolas.pricecoins.data.remoto.source

import com.nicolas.pricecoins.data.remoto.api.ServiceApi
import com.nicolas.pricecoins.data.remoto.mapper.PriceMapper.toEntity
import com.nicolas.pricecoins.domain.entities.CoinUSD

class RemoteDataSourceImpl(private val service: ServiceApi) : RemoteDataSource {

    override suspend fun fetchPrice(): CoinUSD {
        val response = service.fetchPriceCoins()
        return response.toEntity()
    }
}