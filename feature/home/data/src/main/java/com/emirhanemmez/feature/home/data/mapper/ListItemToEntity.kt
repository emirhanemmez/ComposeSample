package com.emirhanemmez.feature.home.data.mapper

import com.emirhanemmez.feature.home.data.dto.ListItem
import com.emirhanemmez.feature.home.domain.entity.ListItemEntity

fun ListItem.toListItemEntity(): ListItemEntity =
    ListItemEntity(
        name = name,
        imageURL = imageUrl
    )