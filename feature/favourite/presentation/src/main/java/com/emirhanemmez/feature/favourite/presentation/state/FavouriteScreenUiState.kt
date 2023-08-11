package com.emirhanemmez.feature.favourite.presentation.state

import com.emirhanemmez.feature.favourite.presentation.data.FavouriteItem

sealed class FavouriteScreenUiState {
    data class Empty(val emptyMessage: String) : FavouriteScreenUiState()
    data object Loading : FavouriteScreenUiState()
    data class Content(val list: List<FavouriteItem>) : FavouriteScreenUiState()
    data class Error(val errorMessage: String) : FavouriteScreenUiState()
}
