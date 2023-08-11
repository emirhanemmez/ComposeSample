package com.emirhanemmez.feature.favourite.presentation.mapper

import com.eemmez.localization.LocalizationManager
import com.emirhanemmez.feature.favourite.domain.entity.FavouriteError
import com.emirhanemmez.feature.favourite.presentation.R
import javax.inject.Inject
import com.emirhanemmez.common.presentation.R as commonResources

class ErrorMessageMapper @Inject constructor(
    private val localizationManager: LocalizationManager
) {
    fun getErrorMessage(favouriteError: FavouriteError?): String =
        when (favouriteError) {
            is FavouriteError.GetFavouritesError -> localizationManager.getString(R.string.get_favourites_error)
            is FavouriteError.DeleteError -> localizationManager.getString(R.string.delete_favourite_error)
            else -> localizationManager.getString(commonResources.string.unknown_error)
        }
}