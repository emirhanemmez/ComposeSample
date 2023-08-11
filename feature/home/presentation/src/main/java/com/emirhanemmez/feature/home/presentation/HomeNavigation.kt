package com.emirhanemmez.feature.home.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.emirhanemmez.feature.home.presentation.model.HomeListItem

object HomeNavigation {
    const val route = "home"
}

fun NavGraphBuilder.homeRoute(onDetailNavigation: (HomeListItem) -> Unit) {
    composable(HomeNavigation.route) {
        HomeRoute(
            onItemClick = {
                onDetailNavigation.invoke(it)
            }
        )
    }
}
