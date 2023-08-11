package com.emirhanemmez.navigation.mapper

import com.emirhanemmez.feature.detail.domain.DetailEntity
import com.emirhanemmez.feature.favourite.presentation.data.FavouriteItem

fun FavouriteItem.toDetailEntity() =
    DetailEntity(
        name = name,
        imageURL = imageURL
    )