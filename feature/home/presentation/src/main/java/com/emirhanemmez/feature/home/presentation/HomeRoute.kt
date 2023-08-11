package com.emirhanemmez.feature.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.emirhanemmez.common.presentation.component.EmptyMessage
import com.emirhanemmez.common.presentation.component.ErrorDialog
import com.emirhanemmez.common.presentation.component.ProgressDialog
import com.emirhanemmez.feature.home.presentation.component.HomeTag
import com.emirhanemmez.feature.home.presentation.component.List
import com.emirhanemmez.feature.home.presentation.component.SearchBox
import com.emirhanemmez.feature.home.presentation.component.Template
import com.emirhanemmez.feature.home.presentation.model.HomeListItem
import com.emirhanemmez.feature.home.presentation.state.HomeScreenUiEvent
import com.emirhanemmez.feature.home.presentation.state.HomeScreenUiState

@Composable
fun HomeRoute(
    homeScreenUiState: HomeScreenUiState,
    homeScreenUiEvent: HomeScreenUiEvent,
    onItemClick: (HomeListItem) -> Unit,
    onItemLongClick: (HomeListItem) -> Unit,
    onTextChanged: (String) -> Unit
) {

    val snackbarHostState = remember {
        SnackbarHostState()
    }

    Template(
        topBar = {
            SearchBox(
                onTextChanged = { onTextChanged(it) }
            )
        }
    ) {
        HomeScreen(
            onItemClick = onItemClick,
            onItemLongClick = { onItemLongClick(it) },
            homeScreenUiState = homeScreenUiState,
            homeScreenUiEvent = homeScreenUiEvent,
            snackbarHostState = snackbarHostState
        )
    }
}

@Composable
private fun HomeScreen(
    onItemClick: (HomeListItem) -> Unit,
    onItemLongClick: (HomeListItem) -> Unit,
    homeScreenUiState: HomeScreenUiState,
    homeScreenUiEvent: HomeScreenUiEvent,
    snackbarHostState: SnackbarHostState
) {
    when (homeScreenUiState) {
        is HomeScreenUiState.Content -> {
            List(
                listItems = homeScreenUiState.list,
                onItemClick = onItemClick,
                onItemLongClick = onItemLongClick
            )
        }

        is HomeScreenUiState.Loading -> {
            ProgressDialog()
        }

        is HomeScreenUiState.Error -> {
            ErrorDialog(errorMessage = homeScreenUiState.errorMessage)
        }

        is HomeScreenUiState.Empty -> {
            EmptyMessage(message = homeScreenUiState.emptyMessage)
        }
    }

    when (homeScreenUiEvent) {
        is HomeScreenUiEvent.AddFavouriteSuccess -> {
            LaunchedEffect(snackbarHostState) {
                snackbarHostState.showSnackbar(homeScreenUiEvent.successMessage)
            }
        }

        is HomeScreenUiEvent.Loading -> {
            ProgressDialog()
        }

        is HomeScreenUiEvent.Error -> {
            ErrorDialog(errorMessage = homeScreenUiEvent.errorMessage)
        }

        else -> Unit
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.BottomCenter)
    ) {
        SnackbarHost(modifier = Modifier.testTag(HomeTag.snackbar), hostState = snackbarHostState)
    }
}
