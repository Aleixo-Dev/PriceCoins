package com.nicolas.pricecoins.domain

import com.nicolas.pricecoins.data.remoto.source.RemoteDataSource
import com.nicolas.pricecoins.extensions.DataState

class PriceRepositoryImpl(private val remote: RemoteDataSource) : PriceRepository {

    override suspend fun fetchCoinUsd() = try {
        DataState.Success(remote.fetchPrice())
    }catch (exception : Exception){
        DataState.Error()
    }
}