package com.emirhanemmez.composesample

import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavHostController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.emirhanemmez.feature.detail.presentation.DetailNavigation
import com.emirhanemmez.feature.favourite.presentation.FavouriteNavigation
import com.emirhanemmez.navigation.Navigation
import com.emirhanemmez.navigation.NavigationTag
import com.emirhanemmez.navigation.component.BottomNavigationBar
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class ScenarioTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    private lateinit var navController: NavHostController

    @Before
    fun setup() {
        hiltRule.inject()
        composeRule.activity.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            BottomNavigationBar(navController)
        }
    }

    @Test
    fun go_detail_from_homeScreen() {
        composeRule.waitUntil {
            composeRule.onAllNodesWithText("kedi1")
                .fetchSemanticsNodes().size == 1
        }
        composeRule.onNodeWithText("kedi1").performClick()
        assert(navController.currentDestination?.route?.startsWith(DetailNavigation.route) == true)
    }

    @Test
    fun go_detail_from_favourite() {
        composeRule.onNodeWithTag(NavigationTag.favouriteItem).performClick()
        composeRule.waitUntil {
            composeRule.onAllNodesWithText("kedi1")
                .fetchSemanticsNodes().size == 1
        }
        composeRule.onNodeWithText("kedi1").performClick()
        assert(navController.currentDestination?.route?.startsWith(DetailNavigation.route) == true)
    }
}