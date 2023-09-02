package com.emirhanemmez.feature.favourite.domain.usecase

import com.emirhanemmez.core.Result
import com.emirhanemmez.feature.favourite.domain.entity.FavouriteItemEntity
import com.emirhanemmez.feature.favourite.domain.repository.FakeFavouriteRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class DeleteFavouriteUseCaseTest {
    private lateinit var fakeFavouriteRepository: FakeFavouriteRepository
    private lateinit var deleteFavouriteUseCase: DeleteFavouriteUseCase

    @Before
    fun setup() {
        fakeFavouriteRepository = FakeFavouriteRepository()
        deleteFavouriteUseCase = DeleteFavouriteUseCase(fakeFavouriteRepository)
    }

    @Test
    fun `Delete operation return success result`() {
        runTest {
            val result =
                deleteFavouriteUseCase.invoke(FavouriteItemEntity("kedi1", "image1")).first()
            assert(result is Result.Success)
        }

    }

    @Test
    fun `Delete operation return error result`() {
        runTest {
            val result =
                deleteFavouriteUseCase.invoke(FavouriteItemEntity("kedi11", "image11")).first()
            assert(result is Result.Error)
        }
    }
}