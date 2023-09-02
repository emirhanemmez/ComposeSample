package com.emirhanemmez.core

import kotlinx.coroutines.flow.Flow

typealias FlowResult<T, E> = Flow<Result<T, E>>

sealed class Result<T, E>(
    val data: T? = null,
    val error: E? = null
) {
    class Success<T, E>(data: T?) : Result<T, E>(data)
    class Loading<T, E>(data: T? = null) : Result<T, E>(data)
    class Error<T, E>(error: E) : Result<T, E>(error = error)
}