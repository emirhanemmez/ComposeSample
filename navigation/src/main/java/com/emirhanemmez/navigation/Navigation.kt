package com.emirhanemmez.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.emirhanemmez.common.presentation.util.extension.parcelableString
import com.emirhanemmez.feature.detail.presentation.DetailNavigation
import com.emirhanemmez.feature.detail.presentation.detailRoute
import com.emirhanemmez.feature.favourite.presentation.favouriteRoute
import com.emirhanemmez.feature.home.presentation.HomeNavigation
import com.emirhanemmez.feature.home.presentation.homeRoute
import com.emirhanemmez.navigation.mapper.toDetailItem

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HomeNavigation.route
    ) {
        homeRoute(
            navigateToDetail = { homeListItem ->
                val detailEntityArg = homeListItem.toDetailItem().parcelableString()
                navController.navigate("${DetailNavigation.route}/$detailEntityArg")
            }
        )
        favouriteRoute(
            navigateToDetail = { favouriteItem ->
                val detailEntityArg = favouriteItem.toDetailItem().parcelableString()
                navController.navigate("${DetailNavigation.route}/$detailEntityArg")
            }
        )
        detailRoute()
    }
}