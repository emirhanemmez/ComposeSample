package com.emirhanemmez.feature.home.data.repository

import com.emirhanemmez.common.data.remote.di.IoDispatcher
import com.emirhanemmez.common.data.remote.dto.Status
import com.emirhanemmez.core.FlowResult
import com.emirhanemmez.core.Result
import com.emirhanemmez.feature.home.data.mapper.HomeErrorMapper
import com.emirhanemmez.feature.home.data.mapper.toFavouriteItem
import com.emirhanemmez.feature.home.data.mapper.toListItemEntity
import com.emirhanemmez.feature.home.data.mapper.toListResponseEntity
import com.emirhanemmez.feature.home.data.service.HomeService
import com.emirhanemmez.feature.home.domain.entity.GetListResponseEntity
import com.emirhanemmez.feature.home.domain.entity.HomeError
import com.emirhanemmez.feature.home.domain.entity.ListItemEntity
import com.emirhanemmez.feature.home.domain.repository.HomeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeService: HomeService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : HomeRepository {
    override fun getList(
        pageNumber: Int?,
        search: String?
    ): FlowResult<GetListResponseEntity, HomeError> =
        flow<Result<GetListResponseEntity, HomeError>> {
            val response = homeService.getList(pageNumber, search)
            emit(
                when (response.status) {
                    Status.SUCCESS -> Result.Success(response.result?.toListResponseEntity())
                    Status.FAIL -> Result.Error(HomeErrorMapper.map(response.errorCode))
                }
            )
        }.onStart {
            emit(Result.Loading())
        }.catch {
            emit(Result.Error(HomeError.UnknownError))
        }.flowOn(ioDispatcher)

    override fun getFavourites(): FlowResult<List<ListItemEntity>, HomeError> =
        flow<Result<List<ListItemEntity>, HomeError>> {
            val response = homeService.getFavourites()
            emit(Result.Success(response.map { it.toListItemEntity() }))
        }.onStart {
            emit(Result.Loading())
        }.catch {
            emit(Result.Error(HomeError.DeleteFavouriteError))
        }

    override fun addFavourite(listItemEntity: ListItemEntity): FlowResult<Unit, HomeError> =
        flow<Result<Unit, HomeError>> {
            homeService.addFavourite(listItemEntity.toFavouriteItem())
            emit(Result.Success(Unit))
        }.onStart {
            emit(Result.Loading())
        }.catch {
            emit(Result.Error(HomeError.AddFavouriteError))
        }.flowOn(ioDispatcher)

    override fun deleteFavourite(listItemEntity: ListItemEntity): FlowResult<Unit, HomeError> =
        flow<Result<Unit, HomeError>> {
            homeService.deleteFavourite(listItemEntity.toFavouriteItem())
            emit(Result.Success(Unit))
        }.onStart {
            emit(Result.Loading())
        }.catch {
            emit(Result.Error(HomeError.DeleteFavouriteError))
        }.flowOn(ioDispatcher)
}
