package com.emirhanemmez.feature.favourite.domain.repository

import com.emirhanemmez.common.domain.Result
import com.emirhanemmez.feature.favourite.domain.entity.FavouriteError
import com.emirhanemmez.feature.favourite.domain.entity.FavouriteItemEntity
import kotlinx.coroutines.flow.Flow

interface FavouriteRepository {
    fun getAll(): Flow<Result<List<FavouriteItemEntity>, FavouriteError.GetFavouritesError>>

    fun delete(favouriteItemEntity: FavouriteItemEntity): Flow<Result<Unit, FavouriteError.DeleteError>>
}