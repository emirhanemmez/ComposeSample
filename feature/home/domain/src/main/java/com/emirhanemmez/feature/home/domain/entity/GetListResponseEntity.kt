package com.emirhanemmez.feature.home.domain.entity

data class GetListResponseEntity(
    val currentPage: Int,
    val nextPageAvailable: Boolean,
    val list: List<ListItemEntity>
)
