package com.emirhanemmez.feature.favourite.domain.usecase

import com.emirhanemmez.common.domain.Result
import com.emirhanemmez.feature.favourite.domain.entity.FavouriteError
import com.emirhanemmez.feature.favourite.domain.entity.FavouriteItemEntity
import com.emirhanemmez.feature.favourite.domain.repository.FavouriteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavouritesUseCase @Inject constructor(
    private val favouriteRepository: FavouriteRepository
) {
    operator fun invoke(): Flow<Result<List<FavouriteItemEntity>, FavouriteError.GetFavouritesError>> =
        favouriteRepository.getAll()
}
