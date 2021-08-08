package com.nicolas.pricecoins.data.remoto.model


import com.google.gson.annotations.SerializedName

data class Currencies(
    @SerializedName("ARS")
    val aRS: ARS,
    @SerializedName("AUD")
    val aUD: AUD,
    @SerializedName("BTC")
    val bTC: BTC,
    @SerializedName("CAD")
    val cAD: CAD,
    @SerializedName("CNY")
    val cNY: CNY,
    @SerializedName("EUR")
    val eUR: EUR,
    @SerializedName("GBP")
    val gBP: GBP,
    @SerializedName("JPY")
    val jPY: JPY,
    @SerializedName("source")
    val source: String,
    @SerializedName("USD")
    val uSD: USD
)