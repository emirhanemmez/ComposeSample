package com.emirhanemmez.common.presentation.util.extension

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import com.emirhanemmez.common.presentation.util.GsonHelper

@Suppress("DEPRECATION")
fun <T : Parcelable> Bundle.getSafeParcelable(key: String, clazz: Class<T>): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelable(key, clazz)
    } else {
        getParcelable(key)
    }
}

fun Parcelable.parcelableString(): String {
    val str = Uri.encode(GsonHelper.gson().toJson(this))
    GsonHelper.clear()
    return str
}