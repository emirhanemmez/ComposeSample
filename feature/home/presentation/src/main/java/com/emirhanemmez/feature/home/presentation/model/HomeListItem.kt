package com.emirhanemmez.feature.home.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeListItem(
    val name: String,
    val imageURL: String
) : Parcelable
