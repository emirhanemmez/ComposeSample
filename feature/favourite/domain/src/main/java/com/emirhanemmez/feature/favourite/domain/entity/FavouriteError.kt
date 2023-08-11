package com.emirhanemmez.feature.favourite.domain.entity

sealed class FavouriteError {
    data object GetFavouritesError : FavouriteError()
    data object DeleteError : FavouriteError()
}
