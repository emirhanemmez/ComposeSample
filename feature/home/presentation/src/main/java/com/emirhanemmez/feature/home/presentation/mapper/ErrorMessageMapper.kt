package com.emirhanemmez.feature.home.presentation.mapper

import com.eemmez.localization.LocalizationManager
import com.emirhanemmez.feature.home.domain.entity.HomeError
import com.emirhanemmez.feature.home.presentation.R
import com.emirhanemmez.common.presentation.R as commonResources

class ErrorMessageMapper(
    private val localizationManager: LocalizationManager
) {
    fun getErrorMessage(error: HomeError?): String =
        when (error) {
            is HomeError.GetListError -> localizationManager.getString(R.string.some_list_error)
            is HomeError.AddToFavouritesError -> localizationManager.getString(R.string.add_favourite_error)
            else -> localizationManager.getString(commonResources.string.unknown_error)
        }

}