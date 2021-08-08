package com.nicolas.pricecoins.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicolas.pricecoins.domain.entities.CoinUSD
import com.nicolas.pricecoins.domain.usecase.GetPriceUsdUseCase
import com.nicolas.pricecoins.extensions.DataState
import kotlinx.coroutines.launch

class MainViewModel(private val getPriceUsdUseCase: GetPriceUsdUseCase) : ViewModel() {

    private val _fetchPriceUsd = MutableLiveData<CoinUSD>()
    val fetchPriceUsd: LiveData<CoinUSD> = _fetchPriceUsd

    private val _observerError = MutableLiveData<String>()
    val observerError: LiveData<String> = _observerError

    init {
        fetchCoin()
    }

    private fun fetchCoin() {
        viewModelScope.launch {
            when (val result = getPriceUsdUseCase.execute()) {
                is DataState.Success -> {
                    result.result.let {
                        _fetchPriceUsd.postValue(it)
                    }
                }
                is DataState.Empty -> {
                    _observerError.postValue("Empty.")
                }
                is DataState.Error -> {
                    _observerError.postValue("Please check you connection internet!")
                }
            }
        }
    }
}