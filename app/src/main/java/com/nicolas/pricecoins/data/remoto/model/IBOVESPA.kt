package com.nicolas.pricecoins.data.remoto.model


import com.google.gson.annotations.SerializedName

data class IBOVESPA(
    @SerializedName("location")
    val location: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("points")
    val points: Double,
    @SerializedName("variation")
    val variation: Double
)