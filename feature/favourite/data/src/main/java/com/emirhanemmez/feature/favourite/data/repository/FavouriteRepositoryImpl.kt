package com.emirhanemmez.feature.favourite.data.repository

import com.emirhanemmez.common.data.local.di.IoDispatcher
import com.emirhanemmez.common.domain.Result
import com.emirhanemmez.feature.favourite.data.mapper.toFavouriteItem
import com.emirhanemmez.feature.favourite.data.mapper.toFavouriteItemEntity
import com.emirhanemmez.feature.favourite.data.service.FavouriteService
import com.emirhanemmez.feature.favourite.domain.entity.FavouriteError
import com.emirhanemmez.feature.favourite.domain.entity.FavouriteItemEntity
import com.emirhanemmez.feature.favourite.domain.repository.FavouriteRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class FavouriteRepositoryImpl @Inject constructor(
    private val favouriteService: FavouriteService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : FavouriteRepository {
    override fun getAll(): Flow<Result<List<FavouriteItemEntity>, FavouriteError.GetFavouritesError>> =
        flow<Result<List<FavouriteItemEntity>, FavouriteError.GetFavouritesError>> {
            val response = favouriteService.getAll()
            emit(Result.Success(response.map { it.toFavouriteItemEntity() }))
        }.onStart {
            emit(Result.Loading())
        }.catch {
            emit(Result.Error(FavouriteError.GetFavouritesError))
        }.flowOn(ioDispatcher)

    override fun delete(favouriteItemEntity: FavouriteItemEntity): Flow<Result<Unit, FavouriteError.DeleteError>> =
        flow<Result<Unit, FavouriteError.DeleteError>> {
            val favouriteItem = favouriteItemEntity.toFavouriteItem()
            favouriteService.delete(favouriteItem)
            emit(Result.Success(Unit))
        }.onStart {
            emit(Result.Loading())
        }.catch {
            emit(Result.Error(FavouriteError.DeleteError))
        }.flowOn(ioDispatcher)
}
