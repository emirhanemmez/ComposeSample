package com.emirhanemmez.feature.home.data.mapper

import com.emirhanemmez.feature.home.data.dto.HomeErrorCode
import com.emirhanemmez.feature.home.domain.entity.HomeError

object HomeErrorMapper {
    fun map(errorCode: HomeErrorCode?): HomeError {
        return when (errorCode) {
            HomeErrorCode.GET_LIST_ERROR -> HomeError.GetListError
            else -> HomeError.UnknownError
        }
    }
}