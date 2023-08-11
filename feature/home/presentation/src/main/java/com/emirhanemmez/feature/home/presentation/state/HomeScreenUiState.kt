package com.emirhanemmez.feature.home.presentation.state

import com.emirhanemmez.feature.home.presentation.model.HomeListItem

sealed class HomeScreenUiState {
    data class Empty(val emptyMessage: String) : HomeScreenUiState()
    data object Loading : HomeScreenUiState()
    data class Error(val errorMessage: String) : HomeScreenUiState()
    data class Content(val list: List<HomeListItem>) : HomeScreenUiState()
}
