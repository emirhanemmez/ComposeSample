package com.emirhanemmez.feature.home.presentation.state

sealed class HomeScreenUiEvent {
    data object Idle : HomeScreenUiEvent()
    data object Loading : HomeScreenUiEvent()
    data class Error(val errorMessage: String) : HomeScreenUiEvent()
    data class AddFavouriteSuccess(val successMessage: String) : HomeScreenUiEvent()
}
