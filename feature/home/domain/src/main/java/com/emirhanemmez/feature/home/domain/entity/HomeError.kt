package com.emirhanemmez.feature.home.domain.entity

sealed class HomeError {
    data object GetListError : HomeError()
    data object AddFavouriteError : HomeError()
    data object DeleteFavouriteError : HomeError()
    data object UnknownError : HomeError()
}
