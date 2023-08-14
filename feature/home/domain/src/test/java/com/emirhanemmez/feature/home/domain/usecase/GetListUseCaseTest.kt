package com.emirhanemmez.feature.home.domain.usecase

import com.emirhanemmez.common.domain.Result
import com.emirhanemmez.feature.home.domain.repository.FakeHomeRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetListUseCaseTest {
    private lateinit var fakeHomeRepository: FakeHomeRepository
    private lateinit var getListUseCase: GetListUseCase

    @Before
    fun setup() {
        fakeHomeRepository = FakeHomeRepository()
        getListUseCase = GetListUseCase(fakeHomeRepository)
    }

    @Test
    fun `get 10 elements every page`() {
        runTest {
            val result = getListUseCase.invoke(0, "").first { result -> result is Result.Success }
            assert(result.data?.list?.size == 10)
        }
    }

    @Test
    fun `search kedi1 get 2 items`() {
        runTest {
            val result = getListUseCase.invoke(0, "kedi1").first { result -> result is Result.Success }
            assert(result.data?.list?.size == 2)
        }
    }

    @Test
    fun `search unknown item get emptyList`() {
        runTest {
            val result = getListUseCase.invoke(0, "köpek").first { result -> result is Result.Success }
            assert(result.data?.list?.size == 0)
        }
    }
}