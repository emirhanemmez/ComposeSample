package com.emirhanemmez.feature.home.presentation.mapper

import com.emirhanemmez.feature.home.domain.entity.ListItemEntity
import com.emirhanemmez.feature.home.presentation.model.HomeListItem

fun ListItemEntity.toHomeListItem() =
    HomeListItem(name, imageURL)

fun HomeListItem.toListItemEntity() =
    ListItemEntity(name, imageURL)
