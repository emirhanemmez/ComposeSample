package com.emirhanemmez.feature.home.domain.usecase

import com.emirhanemmez.core.Result
import com.emirhanemmez.feature.home.domain.entity.ListItemEntity
import com.emirhanemmez.feature.home.domain.repository.FakeHomeRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class DeleteFavouriteUseCaseTest {
    private lateinit var fakeHomeRepository: FakeHomeRepository
    private lateinit var deleteFavouriteUseCase: DeleteFavouriteUseCase

    @Before
    fun setup() {
        fakeHomeRepository = FakeHomeRepository()
        deleteFavouriteUseCase = DeleteFavouriteUseCase(fakeHomeRepository)
    }

    @Test
    fun `get loading result on start`() {
        runTest {
            val result =
                deleteFavouriteUseCase.addFavourite(ListItemEntity("kedi", "image1")).first()
            assert(result is Result.Loading)
        }
    }
}