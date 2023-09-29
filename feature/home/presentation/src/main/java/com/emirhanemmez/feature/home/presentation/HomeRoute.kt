package com.emirhanemmez.feature.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.emirhanemmez.common.presentation.component.ErrorDialog
import com.emirhanemmez.common.presentation.component.ProgressDialog
import com.emirhanemmez.feature.home.presentation.component.HomeListItem
import com.emirhanemmez.feature.home.presentation.component.SearchBox
import com.emirhanemmez.feature.home.presentation.model.HomeListItem
import com.emirhanemmez.feature.home.presentation.state.ListState

@Composable
fun HomeRoute(
    onItemClick: (HomeListItem) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val homeScreenUiState by viewModel.listState.collectAsStateWithLifecycle()
    val homeList = viewModel.homeList
    val canPaginate by viewModel.canPaginateState.collectAsStateWithLifecycle()

    HomeScreen(
        onTextChanged = { searchText ->
            viewModel.getList(search = searchText)
        },
        onItemClick = { homeListItem ->
            onItemClick.invoke(homeListItem)
        },
        onFavouriteAction = { homeListItem ->
            viewModel.favouriteAction(homeListItem)
        },
        onPaginated = { viewModel.getList(isPagination = true) },
        listState = homeScreenUiState,
        homeList = homeList,
        canPaginate = canPaginate
    )
}

@Composable
internal fun HomeScreen(
    onTextChanged: (String) -> Unit,
    onItemClick: (HomeListItem) -> Unit,
    onFavouriteAction: (HomeListItem) -> Unit,
    onPaginated: () -> Unit,
    listState: ListState,
    homeList: List<HomeListItem>,
    canPaginate: Boolean
) {
    Column {
        SearchBox(onTextChanged = onTextChanged)
        Spacer(modifier = Modifier.height(16.dp))
        HomeContent(
            onItemClick = onItemClick,
            onFavouriteAction = onFavouriteAction,
            onPaginated = onPaginated,
            listState = listState,
            homeList = homeList,
            canPaginate = canPaginate
        )
    }
}

@Composable
internal fun HomeContent(
    onItemClick: (HomeListItem) -> Unit,
    onFavouriteAction: (HomeListItem) -> Unit,
    canPaginate: Boolean,
    onPaginated: () -> Unit,
    listState: ListState,
    homeList: List<HomeListItem>
) {
    val lazyColumnState = rememberLazyListState()

    val shouldStartPaginate by remember {
        derivedStateOf {
            canPaginate && (lazyColumnState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
                ?: -9) >= (lazyColumnState.layoutInfo.totalItemsCount - 6)
        }
    }

    LaunchedEffect(shouldStartPaginate) {
        if (shouldStartPaginate && listState == ListState.Content) {
            onPaginated.invoke()
        }
    }

    LazyColumn(state = lazyColumnState) {
        items(
            items = homeList,
            key = { it.name }
        ) { homeListItem ->
            HomeListItem(
                homeListItem = homeListItem,
                onItemClick = onItemClick,
                onFavouriteAction = onFavouriteAction
            )

            Divider()
        }

        item(
            key = listState.javaClass.name
        ) {
            when (listState) {
                ListState.Content -> Unit
                ListState.Loading -> ProgressDialog(modifier = Modifier.fillParentMaxSize())
                ListState.PaginationLoading -> ProgressDialog(
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .padding(16.dp)
                )

                is ListState.Error -> ErrorDialog(
                    modifier = Modifier.testTag(HomeTag.errorDialog),
                    errorMessage = listState.errorMessage
                )

                is ListState.PaginationError -> Text(
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .padding(16.dp),
                    text = listState.errorMessage
                )
            }
        }
    }
}
