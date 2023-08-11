package com.emirhanemmez.feature.favourite.presentation.state

sealed class FavouriteScreenUiEvent {
    data object Idle : FavouriteScreenUiEvent()
    data class Success(val successMessage: String) : FavouriteScreenUiEvent()
    data object Loading : FavouriteScreenUiEvent()
    data class Error(val errorMessage: String) : FavouriteScreenUiEvent()
}
