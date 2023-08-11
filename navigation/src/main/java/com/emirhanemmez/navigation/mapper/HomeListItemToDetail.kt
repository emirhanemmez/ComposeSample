package com.emirhanemmez.navigation.mapper

import com.emirhanemmez.feature.detail.domain.DetailEntity
import com.emirhanemmez.feature.home.presentation.model.HomeListItem

fun HomeListItem.toDetailEntity() =
    DetailEntity(
        name = name,
        imageURL = imageURL
    )
