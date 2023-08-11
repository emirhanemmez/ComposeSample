package com.emirhanemmez.feature.home.domain.usecase

import com.emirhanemmez.common.domain.Result
import com.emirhanemmez.feature.home.domain.entity.HomeError
import com.emirhanemmez.feature.home.domain.entity.ListItemEntity
import com.emirhanemmez.feature.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddToFavouritesUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
) {
    operator fun invoke(listItemEntity: ListItemEntity): Flow<Result<Unit, HomeError>> =
        homeRepository.addToFavourites(listItemEntity)
}
