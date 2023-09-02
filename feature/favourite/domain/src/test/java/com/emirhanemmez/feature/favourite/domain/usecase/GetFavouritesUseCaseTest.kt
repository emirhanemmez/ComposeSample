package com.emirhanemmez.feature.favourite.domain.usecase

import com.emirhanemmez.core.Result
import com.emirhanemmez.feature.favourite.domain.repository.FakeFavouriteRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetFavouritesUseCaseTest {
    private lateinit var fakeFavouriteRepository: FakeFavouriteRepository
    private lateinit var getFavouritesUseCase: GetFavouritesUseCase

    @Before
    fun setup() {
        fakeFavouriteRepository = FakeFavouriteRepository()
        getFavouritesUseCase = GetFavouritesUseCase(fakeFavouriteRepository)
    }

    @Test
    fun `Get all favourites return success result`() {
        runTest {
            val result = getFavouritesUseCase.invoke().first()
            assert(result is Result.Success)
        }
    }
}
