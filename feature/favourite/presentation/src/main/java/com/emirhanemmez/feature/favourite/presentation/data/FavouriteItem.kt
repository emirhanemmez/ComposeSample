package com.emirhanemmez.feature.favourite.presentation.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FavouriteItem(
    val name: String,
    val imageURL: String
) : Parcelable
