package com.emirhanemmez.feature.favourite.data.mapper

import com.emirhanemmez.common.data.local.dto.FavouriteItem
import com.emirhanemmez.feature.favourite.domain.entity.FavouriteItemEntity

fun FavouriteItemEntity.toFavouriteItem() =
    FavouriteItem(
        name = name,
        imageURL = imageURL
    )