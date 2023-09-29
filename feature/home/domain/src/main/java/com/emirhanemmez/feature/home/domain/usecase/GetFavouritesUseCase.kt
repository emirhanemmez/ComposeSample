package com.emirhanemmez.feature.home.domain.usecase

import com.emirhanemmez.core.FlowResult
import com.emirhanemmez.feature.home.domain.entity.HomeError
import com.emirhanemmez.feature.home.domain.entity.ListItemEntity
import com.emirhanemmez.feature.home.domain.repository.HomeRepository
import javax.inject.Inject

class GetFavouritesUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    operator fun invoke(): FlowResult<List<ListItemEntity>, HomeError> =
        homeRepository.getFavourites()
}