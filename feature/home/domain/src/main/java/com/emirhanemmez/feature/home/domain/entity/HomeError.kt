package com.emirhanemmez.feature.home.domain.entity

sealed class HomeError {
    data object GetListError : HomeError()
    data object AddToFavouritesError : HomeError()
    data object UnknownError : HomeError()
}
