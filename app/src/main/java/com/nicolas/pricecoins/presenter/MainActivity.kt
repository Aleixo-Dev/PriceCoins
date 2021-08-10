package com.nicolas.pricecoins.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nicolas.pricecoins.databinding.ActivityMainBinding
import com.nicolas.pricecoins.extensions.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        priceCoinInit()

    }

    private fun priceCoinInit() {

        viewModel.run {

            fetchPriceUsd.observe(this@MainActivity, { result ->
                binding.tvNameCoin.text = result.coinName
            })

            observerError.observe(this@MainActivity, { error ->
                showToast(error)
            })
        }
    }
}
