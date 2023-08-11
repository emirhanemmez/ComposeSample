package com.emirhanemmez.feature.home.data.repository

import com.emirhanemmez.common.data.remote.di.IoDispatcher
import com.emirhanemmez.common.data.remote.dto.Status
import com.emirhanemmez.common.domain.Result
import com.emirhanemmez.feature.home.data.mapper.HomeErrorMapper
import com.emirhanemmez.feature.home.data.mapper.toFavouriteItem
import com.emirhanemmez.feature.home.data.mapper.toListResponseEntity
import com.emirhanemmez.feature.home.data.service.HomeService
import com.emirhanemmez.feature.home.domain.entity.GetListResponseEntity
import com.emirhanemmez.feature.home.domain.entity.HomeError
import com.emirhanemmez.feature.home.domain.entity.ListItemEntity
import com.emirhanemmez.feature.home.domain.repository.HomeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
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
    ): Flow<Result<GetListResponseEntity, HomeError>> =
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

    override fun addToFavourites(listItemEntity: ListItemEntity): Flow<Result<Unit, HomeError>> =
        flow<Result<Unit, HomeError>> {
            homeService.addToFavourites(listItemEntity.toFavouriteItem())
            emit(Result.Success(Unit))
        }.onStart {
            emit(Result.Loading())
        }.catch {
            emit(Result.Error(HomeError.AddToFavouritesError))
        }.flowOn(ioDispatcher)
}
