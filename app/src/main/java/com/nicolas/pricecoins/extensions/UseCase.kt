package com.nicolas.pricecoins.extensions

interface UseCase<in Params, out Output> {
    suspend fun execute(params: Params? = null): DataState<Output>
}