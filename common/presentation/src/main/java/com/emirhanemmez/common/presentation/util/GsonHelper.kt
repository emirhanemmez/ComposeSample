package com.emirhanemmez.common.presentation.util

import com.google.gson.Gson

object GsonHelper {
    private var gson: Gson? = null

    fun gson(): Gson {
        if (gson == null)
            gson = Gson()
        return gson!!
    }

    fun clear() {
        gson = null
    }
}