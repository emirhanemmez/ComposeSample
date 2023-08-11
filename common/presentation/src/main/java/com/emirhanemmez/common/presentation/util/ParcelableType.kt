package com.emirhanemmez.common.presentation.util

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.emirhanemmez.common.presentation.util.extension.getSafeParcelable

class ParcelableType<T : Parcelable>(
    private val clazz: Class<T>
) : NavType<T>(isNullableAllowed = true) {

    override fun get(bundle: Bundle, key: String): T? =
        bundle.getSafeParcelable(key, clazz)

    override fun parseValue(value: String): T =
        GsonHelper.gson().fromJson(value, clazz)

    override fun put(bundle: Bundle, key: String, value: T) {
        GsonHelper.clear()
        bundle.putParcelable(key, value)
    }
}