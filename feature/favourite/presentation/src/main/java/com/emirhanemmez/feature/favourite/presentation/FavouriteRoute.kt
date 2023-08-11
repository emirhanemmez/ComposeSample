package com.emirhanemmez.feature.favourite.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.emirhanemmez.common.presentation.component.EmptyMessage
import com.emirhanemmez.common.presentation.component.ErrorDialog
import com.emirhanemmez.common.presentation.component.ProgressDialog
import com.emirhanemmez.feature.favourite.presentation.component.List
import com.emirhanemmez.feature.favourite.presentation.data.FavouriteItem
import com.emirhanemmez.feature.favourite.presentation.state.FavouriteScreenUiEvent
import com.emirhanemmez.feature.favourite.presentation.state.FavouriteScreenUiState

@Composable
fun FavouriteRoute(
    onItemClick: (FavouriteItem) -> Unit,
    viewModel: FavouriteViewModel
) {
    val favouriteScreenUiState by viewModel.favouriteScreenUiState.collectAsStateWithLifecycle()
    val favouriteScreenUiEvent by viewModel.favouriteScreenUiEvent.collectAsStateWithLifecycle()
    val snackbarHostState = remember {
        SnackbarHostState()
    }

    FavouriteScreen(
        favouriteScreenUiState = favouriteScreenUiState,
        favouriteScreenUiEvent = favouriteScreenUiEvent,
        snackbarHostState = snackbarHostState,
        onItemClick = onItemClick,
        onItemLongClick = { favouriteItem ->
            viewModel.deleteFromFavourites(favouriteItem)
        }
    )
}

@Composable
fun FavouriteScreen(
    favouriteScreenUiState: FavouriteScreenUiState,
    favouriteScreenUiEvent: FavouriteScreenUiEvent,
    snackbarHostState: SnackbarHostState,
    onItemClick: (FavouriteItem) -> Unit,
    onItemLongClick: (FavouriteItem) -> Unit
) {
    when (favouriteScreenUiState) {
        is FavouriteScreenUiState.Content -> {
            List(
                listItems = favouriteScreenUiState.list,
                onItemClick = onItemClick,
                onItemLongClick = onItemLongClick
            )
        }

        is FavouriteScreenUiState.Loading -> {
            ProgressDialog()
        }

        is FavouriteScreenUiState.Error -> {
            ErrorDialog(errorMessage = favouriteScreenUiState.errorMessage)
        }

        is FavouriteScreenUiState.Empty -> {
            EmptyMessage(message = favouriteScreenUiState.emptyMessage)
        }
    }

    when (favouriteScreenUiEvent) {
        is FavouriteScreenUiEvent.Success -> {
            LaunchedEffect(snackbarHostState) {
                snackbarHostState.showSnackbar(favouriteScreenUiEvent.successMessage)
            }
        }

        else -> Unit
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.BottomCenter)
    ) {
        SnackbarHost(hostState = snackbarHostState)
    }
}

