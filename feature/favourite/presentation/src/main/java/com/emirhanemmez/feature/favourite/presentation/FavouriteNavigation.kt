package com.emirhanemmez.feature.favourite.presentation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.emirhanemmez.feature.favourite.presentation.data.FavouriteItem

object FavouriteNavigation {
    const val route = "favourite"
}

fun NavGraphBuilder.favouriteRoute(onDetailNavigation: (FavouriteItem) -> Unit) =
    composable(FavouriteNavigation.route) {
        val favouriteViewModel = hiltViewModel<FavouriteViewModel>()
        FavouriteRoute(
            onItemClick = { favouriteItem ->
                onDetailNavigation.invoke(favouriteItem)
            },
            viewModel = favouriteViewModel
        )
    }