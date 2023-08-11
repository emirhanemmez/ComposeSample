package com.emirhanemmez.navigation

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavigationViewModel @Inject constructor(
    private val gson: Gson
) : ViewModel() {
    fun <T> getParcelableString(parcelableData: T): String =
        Uri.encode(gson.toJson(parcelableData))

    fun gson(): Gson = gson
}
