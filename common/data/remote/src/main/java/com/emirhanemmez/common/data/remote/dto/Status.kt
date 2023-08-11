package com.emirhanemmez.common.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Status {
    @SerialName("success")
    SUCCESS,

    @SerialName("fail")
    FAIL
}