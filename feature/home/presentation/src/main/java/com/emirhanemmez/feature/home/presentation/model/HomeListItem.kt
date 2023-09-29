package com.emirhanemmez.feature.home.presentation.model

import android.os.Parcelable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeListItem(
    val name: String,
    val imageURL: String
) : Parcelable {
    @IgnoredOnParcel
    var isFavourite by mutableStateOf(false)
}
