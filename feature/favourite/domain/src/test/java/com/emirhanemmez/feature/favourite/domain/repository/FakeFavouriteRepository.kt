package com.emirhanemmez.feature.favourite.domain.repository

import com.emirhanemmez.common.domain.Result
import com.emirhanemmez.feature.favourite.domain.entity.FavouriteError
import com.emirhanemmez.feature.favourite.domain.entity.FavouriteItemEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeFavouriteRepository : FavouriteRepository {
    private val favouriteItemEntityList = mutableListOf(
        FavouriteItemEntity("kedi1", "image1"),
        FavouriteItemEntity("kedi2", "image2"),
        FavouriteItemEntity("kedi3", "image3"),
        FavouriteItemEntity("kedi4", "image4"),
        FavouriteItemEntity("kedi5", "image5"),
        FavouriteItemEntity("kedi6", "image6"),
        FavouriteItemEntity("kedi7", "image7"),
        FavouriteItemEntity("kedi8", "image8"),
    )

    override fun getAll(): Flow<Result<List<FavouriteItemEntity>, FavouriteError.GetFavouritesError>> =
        flow {
            emit(Result.Success(data = favouriteItemEntityList))
        }

    override fun delete(favouriteItemEntity: FavouriteItemEntity): Flow<Result<Unit, FavouriteError.DeleteError>> =
        flow {
            if (favouriteItemEntityList.remove(favouriteItemEntity)) {
                emit(Result.Success(Unit))
            } else {
                emit(Result.Error(FavouriteError.DeleteError))
            }
        }
}