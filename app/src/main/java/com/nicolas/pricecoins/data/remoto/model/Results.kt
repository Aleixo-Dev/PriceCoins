package com.nicolas.pricecoins.data.remoto.model


import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("available_sources")
    val availableSources: List<String>,
    @SerializedName("currencies")
    val currencies: Currencies,
    @SerializedName("stocks")
    val stocks: Stocks,
    @SerializedName("taxes")
    val taxes: List<Any>
)