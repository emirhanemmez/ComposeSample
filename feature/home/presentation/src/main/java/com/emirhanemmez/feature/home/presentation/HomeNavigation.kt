package com.emirhanemmez.feature.home.presentation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.emirhanemmez.feature.home.presentation.model.HomeListItem

object HomeNavigation {
    const val route = "home"
}

fun NavGraphBuilder.homeScreen(onDetailNavigation: (HomeListItem) -> Unit) {
    composable(HomeNavigation.route) {
        val viewModel: HomeViewModel = hiltViewModel()
        val homeScreenUiState by viewModel.homeScreenUiState.collectAsStateWithLifecycle()
        val homeScreenUiEvent by viewModel.homeScreenUiEvent.collectAsStateWithLifecycle()

        HomeRoute(
            homeScreenUiState = homeScreenUiState,
            homeScreenUiEvent = homeScreenUiEvent,
            onItemClick = { onDetailNavigation.invoke(it) },
            onItemLongClick = { viewModel.addToFavourites(it) },
            onTextChanged = { viewModel.getList(0, it) }
        )
    }
}
