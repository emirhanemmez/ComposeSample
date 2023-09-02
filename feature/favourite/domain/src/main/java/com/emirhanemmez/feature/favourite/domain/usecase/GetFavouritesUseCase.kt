package com.emirhanemmez.feature.favourite.domain.usecase

import com.emirhanemmez.core.FlowResult
import com.emirhanemmez.feature.favourite.domain.entity.FavouriteError
import com.emirhanemmez.feature.favourite.domain.entity.FavouriteItemEntity
import com.emirhanemmez.feature.favourite.domain.repository.FavouriteRepository
import javax.inject.Inject

class GetFavouritesUseCase @Inject constructor(
    private val favouriteRepository: FavouriteRepository
) {
    operator fun invoke(): FlowResult<List<FavouriteItemEntity>, FavouriteError.GetFavouritesError> =
        favouriteRepository.getAll()
}
