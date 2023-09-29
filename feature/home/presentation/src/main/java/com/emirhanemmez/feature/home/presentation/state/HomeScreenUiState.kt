package com.emirhanemmez.feature.home.presentation.state

sealed class HomeScreenUiState {
    data class Empty(val emptyMessage: String) : HomeScreenUiState()
    data object Loading : HomeScreenUiState()
    data class Error(val errorMessage: String) : HomeScreenUiState()
    data object Content : HomeScreenUiState()
}
