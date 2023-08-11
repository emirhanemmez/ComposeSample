package com.emirhanemmez.feature.home.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class HomeErrorCode {
    @SerialName("9141L")
    GET_LIST_ERROR
}