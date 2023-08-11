package com.emirhanemmez.feature.favourite.presentation.mapper

import com.emirhanemmez.feature.favourite.domain.entity.FavouriteItemEntity
import com.emirhanemmez.feature.favourite.presentation.data.FavouriteItem

fun FavouriteItemEntity.toFavouriteItem() =
    FavouriteItem(name, imageURL)

fun FavouriteItem.toFavouriteItemEntity() =
    FavouriteItemEntity(name, imageURL)