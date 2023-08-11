package com.emirhanemmez.feature.home.data.mapper

import com.emirhanemmez.feature.home.data.dto.GetListResponse
import com.emirhanemmez.feature.home.domain.entity.GetListResponseEntity

fun GetListResponse.toListResponseEntity() =
    GetListResponseEntity(
        currentPage = currentPage,
        nextPageAvailable = nextPageAvailable,
        list = list.map { it.toListItemEntity() }
    )