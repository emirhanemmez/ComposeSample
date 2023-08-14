package com.emirhanemmez.feature.favourite.presentation

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
import com.emirhanemmez.feature.favourite.presentation.data.FavouriteItem
import com.emirhanemmez.feature.favourite.presentation.state.FavouriteScreenUiEvent
import com.emirhanemmez.feature.favourite.presentation.state.FavouriteScreenUiState
import org.junit.Rule
import org.junit.Test

class FavouriteScreenTest {
    @get:Rule
    val composeRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun isList_exists() {
        composeRule.setContent {
            FavouriteScreen(
                favouriteScreenUiState = FavouriteScreenUiState.Content(listOf(FavouriteItem("kedi", "image1"))),
                favouriteScreenUiEvent = FavouriteScreenUiEvent.Idle,
                snackbarHostState = SnackbarHostState(),
                onItemClick = {},
                onItemLongClick = {}
            )
        }
        composeRule.onNodeWithTag(FavouriteTag.list).assertExists()
    }

    @Test
    fun isSnackbar_displayed_when_longClick_list_item() {
        composeRule.setContent {
            var favouriteScreenUiEvent: FavouriteScreenUiEvent by remember {
                mutableStateOf(FavouriteScreenUiEvent.Idle)
            }
            FavouriteScreen(
                onItemClick = {},
                onItemLongClick = {
                    favouriteScreenUiEvent = FavouriteScreenUiEvent.DeleteSuccess("Deleted Successfully!")
                },
                favouriteScreenUiState = FavouriteScreenUiState.Content(
                    listOf(
                        FavouriteItem(
                            "kedi1",
                            "image1"
                        )
                    )
                ),
                favouriteScreenUiEvent = favouriteScreenUiEvent,
                snackbarHostState = SnackbarHostState()
            )
        }

        composeRule.onNodeWithText("kedi1").performTouchInput { longClick() }
        composeRule.waitUntil {
            composeRule.onAllNodesWithTag(FavouriteTag.snackbar)
                .fetchSemanticsNodes().size == 1
        }
        composeRule.onNodeWithTag(FavouriteTag.snackbar).assertIsDisplayed()
    }
}