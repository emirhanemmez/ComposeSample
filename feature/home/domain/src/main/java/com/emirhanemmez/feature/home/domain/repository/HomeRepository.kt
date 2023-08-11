package com.emirhanemmez.feature.home.domain.repository

import com.emirhanemmez.common.domain.Result
import com.emirhanemmez.feature.home.domain.entity.GetListResponseEntity
import com.emirhanemmez.feature.home.domain.entity.HomeError
import com.emirhanemmez.feature.home.domain.entity.ListItemEntity
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getList(pageNumber: Int?, search: String?): Flow<Result<GetListResponseEntity, HomeError>>
    fun addToFavourites(listItemEntity: ListItemEntity): Flow<Result<Unit, HomeError>>
}