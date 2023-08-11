package com.emirhanemmez.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.emirhanemmez.feature.detail.presentation.DetailNavigation
import com.emirhanemmez.feature.detail.presentation.detailScreen
import com.emirhanemmez.feature.favourite.presentation.favouriteScreen
import com.emirhanemmez.feature.home.presentation.HomeNavigation
import com.emirhanemmez.feature.home.presentation.homeScreen
import com.emirhanemmez.navigation.mapper.toDetailEntity

@Composable
fun Navigation(
    navController: NavHostController,
    viewModel: NavigationViewModel = hiltViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = HomeNavigation.route
    ) {
        homeScreen(
            onDetailNavigation = { homeListItem ->
                val detailEntityArg = viewModel.getParcelableString(homeListItem.toDetailEntity())
                navController.navigate("${DetailNavigation.route}/$detailEntityArg")
            }
        )
        favouriteScreen(
            onDetailNavigation = { favouriteItem ->
                val detailEntityArg = viewModel.getParcelableString(favouriteItem.toDetailEntity())
                navController.navigate("${DetailNavigation.route}/$detailEntityArg")
            }
        )
        detailScreen()
    }
}