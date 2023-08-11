package com.emirhanemmez.navigation.mapper

import com.emirhanemmez.feature.detail.presentation.data.DetailItem
import com.emirhanemmez.feature.favourite.presentation.data.FavouriteItem

fun FavouriteItem.toDetailItem() =
    DetailItem(
        name = name,
        imageURL = imageURL
    )