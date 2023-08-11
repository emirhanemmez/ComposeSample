package com.emirhanemmez.feature.detail.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.emirhanemmez.common.presentation.util.ParcelableType
import com.emirhanemmez.common.presentation.util.extension.getSafeParcelable
import com.emirhanemmez.feature.detail.presentation.data.DetailItem

object DetailNavigation {
    internal const val detailEntityArg = "detailEntityArg"
    const val route = "detail"
    internal const val routeWithArgs = "$route/{$detailEntityArg}"
}

fun NavGraphBuilder.detailRoute() =
    composable(
        route = DetailNavigation.routeWithArgs,
        arguments = listOf(
            navArgument(DetailNavigation.detailEntityArg) {
                type = ParcelableType(DetailItem::class.java)
            }
        )
    ) {
        it.arguments?.getSafeParcelable(
            DetailNavigation.detailEntityArg,
            DetailItem::class.java
        )?.let { detailEntityArg ->
            DetailScreen(detailItem = detailEntityArg)
        }
    }