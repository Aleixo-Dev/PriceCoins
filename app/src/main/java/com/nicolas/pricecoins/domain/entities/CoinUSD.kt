package com.nicolas.pricecoins.domain.entities

data class CoinUSD(
    val coinName: String,
    val currentValueBuy: Double,
    val currentValueSale: Double,
    val variation: Double,
)
