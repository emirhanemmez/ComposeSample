package com.emirhanemmez.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.emirhanemmez.feature.detail.presentation.DetailNavigation
import com.emirhanemmez.feature.detail.presentation.detailRoute
import com.emirhanemmez.feature.favourite.presentation.favouriteRoute
import com.emirhanemmez.feature.home.presentation.HomeNavigation
import com.emirhanemmez.feature.home.presentation.homeRoute
import com.emirhanemmez.navigation.mapper.toDetailItem

@Composable
fun Navigation(
    navController: NavHostController,
    viewModel: NavigationViewModel = hiltViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = HomeNavigation.route
    ) {
        homeRoute(
            onDetailNavigation = { homeListItem ->
                val detailEntityArg = viewModel.getParcelableString(homeListItem.toDetailItem())
                navController.navigate("${DetailNavigation.route}/$detailEntityArg")
            }
        )
        favouriteRoute(
            onDetailNavigation = { favouriteItem ->
                val detailEntityArg = viewModel.getParcelableString(favouriteItem.toDetailItem())
                navController.navigate("${DetailNavigation.route}/$detailEntityArg")
            }
        )
        detailRoute(

        )
    }
}