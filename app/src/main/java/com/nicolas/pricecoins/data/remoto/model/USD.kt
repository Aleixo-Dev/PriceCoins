package com.nicolas.pricecoins.data.remoto.model


import com.google.gson.annotations.SerializedName

data class USD(
    @SerializedName("buy")
    val buy: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("sell")
    val sell: Double,
    @SerializedName("variation")
    val variation: Double
)