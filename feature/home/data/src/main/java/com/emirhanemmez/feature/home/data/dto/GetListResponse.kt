package com.emirhanemmez.feature.home.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class GetListResponse(
    val currentPage: Int,
    val nextPageAvailable: Boolean,
    val list: List<ListItem>
)
