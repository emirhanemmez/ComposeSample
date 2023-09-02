package com.emirhanemmez.feature.favourite.domain.usecase

import com.emirhanemmez.core.FlowResult
import com.emirhanemmez.feature.favourite.domain.entity.FavouriteError
import com.emirhanemmez.feature.favourite.domain.entity.FavouriteItemEntity
import com.emirhanemmez.feature.favourite.domain.repository.FavouriteRepository
import javax.inject.Inject

class DeleteFavouriteUseCase @Inject constructor(
    private val favouriteRepository: FavouriteRepository
) {
    operator fun invoke(favouriteItemEntity: FavouriteItemEntity): FlowResult<Unit, FavouriteError.DeleteError> =
        favouriteRepository.delete(favouriteItemEntity)
}