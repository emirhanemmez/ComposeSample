package com.emirhanemmez.feature.favourite.presentation.state

sealed class FavouriteScreenUiEvent {
    data object Idle : FavouriteScreenUiEvent()
    data class DeleteSuccess(val successMessage: String) : FavouriteScreenUiEvent()
    data object Loading : FavouriteScreenUiEvent()
    data class DeleteError(val errorMessage: String) : FavouriteScreenUiEvent()
}
