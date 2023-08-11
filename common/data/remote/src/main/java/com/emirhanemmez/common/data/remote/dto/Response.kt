package com.emirhanemmez.common.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Response<T, E>(
    val status: Status,
    val result: T?,
    val errorCode: E?
)
