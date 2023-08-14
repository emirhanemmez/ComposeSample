package com.emirhanemmez.feature.home.presentation

import androidx.activity.ComponentActivity
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.longClick
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTouchInput
import com.emirhanemmez.feature.home.presentation.model.HomeListItem
import com.emirhanemmez.feature.home.presentation.state.HomeScreenUiEvent
import com.emirhanemmez.feature.home.presentation.state.HomeScreenUiState
import org.junit.Rule
import org.junit.Test
import com.emirhanemmez.common.presentation.R as commonPresentationRes

class HomeScreenTest {
    @get:Rule
    val composeRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun isExist_searchBar() {
        composeRule.setContent {
            HomeScreen(
                onTextChanged = {},
                onItemClick = {},
                onItemLongClick = {},
                homeScreenUiState = HomeScreenUiState.Content(listOf()),
                homeScreenUiEvent = HomeScreenUiEvent.Idle,
                snackbarHostState = SnackbarHostState()
            )
        }
        composeRule.onNodeWithTag(HomeTag.searchBox).assertExists()
    }

    @Test
    fun isErrorDialog_displayed_on_error_state() {
        val errorMessage =
            composeRule.activity.getString(commonPresentationRes.string.unknown_error)
        composeRule.setContent {
            HomeScreen(
                onTextChanged = {},
                onItemClick = {},
                onItemLongClick = {},
                homeScreenUiState = HomeScreenUiState.Error(errorMessage),
                homeScreenUiEvent = HomeScreenUiEvent.Idle,
                snackbarHostState = SnackbarHostState()
            )
        }
        composeRule.onNodeWithText(composeRule.activity.getString(commonPresentationRes.string.unknown_error))
            .assertIsDisplayed()
    }

    @Test
    fun isSnackbar_displayed_when_longClick_list_item() {
        composeRule.setContent {
            var homeScreenUiEvent: HomeScreenUiEvent by remember {
                mutableStateOf(HomeScreenUiEvent.Idle)
            }
            HomeScreen(
                onTextChanged = {},
                onItemClick = {},
                onItemLongClick = {
                    homeScreenUiEvent = HomeScreenUiEvent.AddFavouriteSuccess("Added Successfully!")
                },
                homeScreenUiState = HomeScreenUiState.Content(
                    listOf(
                        HomeListItem(
                            "kedi1",
                            "image1"
                        )
                    )
                ),
                homeScreenUiEvent = homeScreenUiEvent,
                snackbarHostState = SnackbarHostState()
            )
        }

        composeRule.onNodeWithText("kedi1").performTouchInput { longClick() }
        composeRule.waitUntil {
            composeRule.onAllNodesWithTag(HomeTag.snackbar)
                .fetchSemanticsNodes().size == 1
        }
        composeRule.onNodeWithTag(HomeTag.snackbar).assertIsDisplayed()
    }
}