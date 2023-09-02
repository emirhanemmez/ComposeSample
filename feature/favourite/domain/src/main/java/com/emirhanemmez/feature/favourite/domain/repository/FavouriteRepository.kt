package com.emirhanemmez.feature.favourite.domain.repository

import com.emirhanemmez.core.FlowResult
import com.emirhanemmez.feature.favourite.domain.entity.FavouriteError
import com.emirhanemmez.feature.favourite.domain.entity.FavouriteItemEntity

interface FavouriteRepository {
    fun getAll(): FlowResult<List<FavouriteItemEntity>, FavouriteError.GetFavouritesError>

    fun delete(favouriteItemEntity: FavouriteItemEntity): FlowResult<Unit, FavouriteError.DeleteError>
}