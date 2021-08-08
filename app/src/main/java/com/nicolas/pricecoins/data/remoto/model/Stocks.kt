package com.nicolas.pricecoins.data.remoto.model


import com.google.gson.annotations.SerializedName

data class Stocks(
    @SerializedName("CAC")
    val cAC: CAC,
    @SerializedName("DOWJONES")
    val dOWJONES: DOWJONES,
    @SerializedName("IBOVESPA")
    val iBOVESPA: IBOVESPA,
    @SerializedName("IFIX")
    val iFIX: IFIX,
    @SerializedName("NASDAQ")
    val nASDAQ: NASDAQ,
    @SerializedName("NIKKEI")
    val nIKKEI: NIKKEI
)