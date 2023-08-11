package com.emirhanemmez.feature.detail.presentation.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailItem(
    val name: String,
    val imageURL: String
) : Parcelable
