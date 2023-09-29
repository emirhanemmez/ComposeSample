package com.emirhanemmez.feature.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emirhanemmez.core.Result
import com.emirhanemmez.feature.home.domain.entity.GetListResponseEntity
import com.emirhanemmez.feature.home.domain.entity.HomeError
import com.emirhanemmez.feature.home.domain.usecase.AddFavouriteUseCase
import com.emirhanemmez.feature.home.domain.usecase.DeleteFavouriteUseCase
import com.emirhanemmez.feature.home.domain.usecase.GetFavouritesUseCase
import com.emirhanemmez.feature.home.domain.usecase.GetListUseCase
import com.emirhanemmez.feature.home.presentation.mapper.ErrorMessageMapper
import com.emirhanemmez.feature.home.presentation.mapper.toHomeListItem
import com.emirhanemmez.feature.home.presentation.mapper.toListItemEntity
import com.emirhanemmez.feature.home.presentation.model.HomeListItem
import com.emirhanemmez.feature.home.presentation.state.ListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getListUseCase: GetListUseCase,
    private val getFavouritesUseCase: GetFavouritesUseCase,
    private val addFavouriteUseCase: AddFavouriteUseCase,
    private val deleteFavouriteUseCase: DeleteFavouriteUseCase,
    private val errorMessageMapper: ErrorMessageMapper
) : ViewModel() {
    private val _listState = MutableStateFlow<ListState>(ListState.Loading)
    val listState: StateFlow<ListState> = _listState

    private val _homeList = mutableStateListOf<HomeListItem>()
    val homeList: List<HomeListItem> = _homeList

    private var pageNumber by mutableIntStateOf(0)

    private val _canPaginateState = MutableStateFlow(true)
    val canPaginateState: StateFlow<Boolean> = _canPaginateState

    init {
        getList()
    }

    fun getList(isPagination: Boolean = false, search: String = "") {
        viewModelScope.launch {
            if (isPagination && _canPaginateState.value) {
                pageNumber++
            } else {
                pageNumber = 0
            }

            if (_canPaginateState.value) {
                getListUseCase.invoke(pageNumber, search)
                    .onCompletion {
                        getFavourites()
                    }.collect { result ->
                        _listState.value = ListState.Content
                        handleListResult(isPagination, result)
                    }
            }
        }
    }

    private fun getFavourites() {
        viewModelScope.launch {
            getFavouritesUseCase.invoke().collect { result ->
                when (result) {
                    is Result.Success -> {
                        _homeList.forEachIndexed { index, homeListItem ->
                            if (result.data?.contains(homeListItem.toListItemEntity()) == true) {
                                _homeList[index].isFavourite = true
                            }
                        }
                    }

                    else -> Unit
                }
            }
        }
    }

    fun favouriteAction(homeListItem: HomeListItem) {
        viewModelScope.launch {
            if (homeListItem.isFavourite) {
                deleteFavouriteUseCase.invoke(homeListItem.toListItemEntity()).collect { result ->
                    when (result) {
                        is Result.Success -> {
                            _homeList[_homeList.indexOf(homeListItem)].isFavourite = false
                        }

                        else -> Unit
                    }
                }
            } else {
                addFavouriteUseCase.invoke(homeListItem.toListItemEntity()).collect { result ->
                    when (result) {
                        is Result.Success -> {
                            _homeList[_homeList.indexOf(homeListItem)].isFavourite = true
                        }

                        else -> Unit
                    }
                }
            }
        }
    }

    private fun handleListResult(
        isPagination: Boolean, result: Result<GetListResponseEntity, HomeError>
    ) {
        when (result) {
            is Result.Success -> {
                result.data?.let { response ->
                    if (!isPagination) {
                        _homeList.clear()
                    }
                    _homeList.addAll(response.list.map { it.toHomeListItem() })

                    val canPaginate = result.data?.nextPageAvailable ?: false
                    _canPaginateState.value = canPaginate
                }
            }

            is Result.Loading -> {
                _listState.value = if (isPagination) {
                    ListState.PaginationLoading
                } else ListState.Loading
            }

            is Result.Error -> {
                _listState.value = if (isPagination) {
                    ListState.PaginationError(errorMessageMapper.getErrorMessage(result.error))
                } else {
                    ListState.Error(errorMessageMapper.getErrorMessage(result.error))
                }
            }
        }
    }
}
