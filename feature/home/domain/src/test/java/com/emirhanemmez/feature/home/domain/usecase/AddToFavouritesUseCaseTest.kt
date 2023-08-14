package com.emirhanemmez.feature.home.domain.usecase

import com.emirhanemmez.common.domain.Result
import com.emirhanemmez.feature.home.domain.entity.ListItemEntity
import com.emirhanemmez.feature.home.domain.repository.FakeHomeRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class AddToFavouritesUseCaseTest {
    private lateinit var fakeHomeRepository: FakeHomeRepository
    private lateinit var addToFavouritesUseCase: AddToFavouritesUseCase

    @Before
    fun setup() {
        fakeHomeRepository = FakeHomeRepository()
        addToFavouritesUseCase = AddToFavouritesUseCase(fakeHomeRepository)
    }

    @Test
    fun `get loading result on start`() {
        runTest {
            val result = addToFavouritesUseCase.invoke(ListItemEntity("kedi", "image1")).first()
            assert(result is Result.Loading)
        }
    }
}