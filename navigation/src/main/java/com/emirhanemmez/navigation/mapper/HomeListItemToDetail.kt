package com.emirhanemmez.navigation.mapper

import com.emirhanemmez.feature.detail.presentation.data.DetailItem
import com.emirhanemmez.feature.home.presentation.model.HomeListItem

fun HomeListItem.toDetailItem() =
    DetailItem(
        name = name,
        imageURL = imageURL
    )
