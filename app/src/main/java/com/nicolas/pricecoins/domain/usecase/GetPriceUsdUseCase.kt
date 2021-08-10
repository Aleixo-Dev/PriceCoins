package com.nicolas.pricecoins.domain.usecase

import com.nicolas.pricecoins.domain.PriceRepository
import com.nicolas.pricecoins.domain.entities.CoinUSD
import com.nicolas.pricecoins.extensions.DataState

import com.nicolas.pricecoins.extensions.UseCase

class GetPriceUsdUseCase(private val repository: PriceRepository) : UseCase<Unit, CoinUSD> {
    override suspend fun execute(params: Unit?): DataState<CoinUSD> {
        return repository.fetchCoinUsd()
    }
}