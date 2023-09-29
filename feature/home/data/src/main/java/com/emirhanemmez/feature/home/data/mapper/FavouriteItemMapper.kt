package com.emirhanemmez.feature.home.data.mapper

import com.emirhanemmez.common.data.local.dto.FavouriteItem
import com.emirhanemmez.feature.home.domain.entity.ListItemEntity

fun ListItemEntity.toFavouriteItem(): FavouriteItem =
    FavouriteItem(
        name = name,
        imageURL = imageURL
    )

fun FavouriteItem.toListItemEntity(): ListItemEntity =
    ListItemEntity(
        name = name,
        imageURL = imageURL
    )