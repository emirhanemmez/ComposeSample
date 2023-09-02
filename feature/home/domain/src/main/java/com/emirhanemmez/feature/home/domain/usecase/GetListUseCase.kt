package com.emirhanemmez.feature.home.domain.usecase

import com.emirhanemmez.core.FlowResult
import com.emirhanemmez.feature.home.domain.entity.GetListResponseEntity
import com.emirhanemmez.feature.home.domain.entity.HomeError
import com.emirhanemmez.feature.home.domain.repository.HomeRepository
import javax.inject.Inject

class GetListUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    operator fun invoke(
        pageNumber: Int,
        search: String
    ): FlowResult<GetListResponseEntity, HomeError> = homeRepository.getList(pageNumber, search)
}