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
            HomeError.GetListError -> localizationManager.getString(R.string.some_list_error)
            HomeError.AddFavouriteError -> localizationManager.getString(R.string.add_favourite_error)
            HomeError.DeleteFavouriteError -> localizationManager.getString(R.string.delete_favourite_error)
            else -> localizationManager.getString(commonResources.string.unknown_error)
        }

}