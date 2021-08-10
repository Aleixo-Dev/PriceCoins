package com.nicolas.pricecoins.data.remoto.api

import com.nicolas.pricecoins.data.remoto.model.ApiResponse
import com.nicolas.pricecoins.extensions.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    @GET(Constants.ENDPOINT)
    suspend fun fetchPriceCoins(
        @Query("key") key: String = Constants.KEY
    ): ApiResponse

}