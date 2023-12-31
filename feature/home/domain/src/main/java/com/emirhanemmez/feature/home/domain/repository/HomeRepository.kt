package com.emirhanemmez.feature.home.domain.repository

import com.emirhanemmez.core.FlowResult
import com.emirhanemmez.feature.home.domain.entity.GetListResponseEntity
import com.emirhanemmez.feature.home.domain.entity.HomeError
import com.emirhanemmez.feature.home.domain.entity.ListItemEntity

interface HomeRepository {
    fun getList(pageNumber: Int?, search: String?): FlowResult<GetListResponseEntity, HomeError>
    fun getFavourites(): FlowResult<List<ListItemEntity>, HomeError>
    fun addFavourite(listItemEntity: ListItemEntity): FlowResult<Unit, HomeError>
    fun deleteFavourite(listItemEntity: ListItemEntity): FlowResult<Unit, HomeError>
}