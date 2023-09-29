package com.emirhanemmez.feature.home.presentation.state

sealed class ListState {
    data object Content : ListState()
    data class Error(val errorMessage: String) : ListState()
    data object Loading : ListState()
    data object PaginationLoading : ListState()
    data class PaginationError(val errorMessage: String) : ListState()
}