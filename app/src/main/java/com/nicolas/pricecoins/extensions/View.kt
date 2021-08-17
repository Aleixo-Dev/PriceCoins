package com.nicolas.pricecoins.extensions

import android.content.Context
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}
fun View.setIsVisible(visible: Boolean) {
    visibility = if (visible) {
        VISIBLE
    } else {
        GONE
    }
}