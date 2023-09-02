package com.emirhanemmez.feature.home.data.service

import com.emirhanemmez.common.data.remote.dto.Response
import com.emirhanemmez.common.data.remote.dto.Status
import com.emirhanemmez.core.Result
import com.emirhanemmez.feature.home.data.dto.GetListResponse
import com.emirhanemmez.feature.home.data.dto.HomeErrorCode
import com.emirhanemmez.feature.home.data.repository.HomeRepositoryImpl
import com.emirhanemmez.feature.home.domain.entity.HomeError
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test

class HomeServiceTest {
    private val homeService = mockk<HomeService>(relaxed = true)
    private val homeRepository = HomeRepositoryImpl(homeService, Dispatchers.IO)

    @Test
    fun `get empty list when search string is wrong`() {
        runTest {
            coEvery {
                homeService.getList(0, "köpek")
            } returns Response(
                status = Status.SUCCESS,
                result = GetListResponse(0, true, listOf()),
                errorCode = null
            )

            val result = homeRepository.getList(0, "köpek").first { result ->
                result is Result.Success
            }
            coVerify { homeService.getList(0, "köpek") }
            assert(result.data?.list?.isEmpty() == true)
        }
    }

    @Test
    fun `throw GetListError when errorCode is GET_LIST_ERROR(9141L)`() {
        runTest {
            coEvery {
                homeService.getList(-1, "kedi")
            } returns Response(
                status = Status.FAIL,
                result = null,
                errorCode = HomeErrorCode.GET_LIST_ERROR
            )

            val result = homeRepository.getList(-1, "kedi").first { result ->
                result is Result.Error
            }

            coVerify { homeService.getList(-1, "kedi") }
            assert(result.error == HomeError.GetListError)
        }
    }

    @Test
    fun `throw UnknownError when an exception caused`() {
        runTest {
            coEvery {
                homeService.getList(-1, "kedi")
            } answers {
                throw RuntimeException()
            }

            val result = homeRepository.getList(-1, "kedi").first { result ->
                result is Result.Error
            }

            coVerify { homeService.getList(-1, "kedi") }
            assert(result.error == HomeError.UnknownError)
        }
    }
}