package com.emirhanemmez.feature.detail.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.emirhanemmez.common.presentation.util.extension.getSafeParcelable
import com.emirhanemmez.feature.detail.presentation.data.DetailItem

object DetailNavigation {
    const val route = "detail/{detailEntityArg}"
    const val detailEntityArg = "detailEntityArg"
}

fun NavGraphBuilder.detailScreen() =
    composable(
        route = DetailNavigation.route,
        arguments = listOf(navArgument(DetailNavigation.detailEntityArg) {
            type = NavType.ParcelableType(DetailItem::class.java)
        })
    ) {
        it.arguments?.getSafeParcelable(
            DetailNavigation.detailEntityArg,
            DetailItem::class.java
        )
            ?.let { detailEntityArg ->
                DetailScreen(detailItem = detailEntityArg)
            }
    }