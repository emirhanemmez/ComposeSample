package com.emirhanemmez.navigation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.emirhanemmez.navigation.Navigation

@Composable
fun BottomNavigationBar() {
    val screens = listOf(
        BottomNavItem(
            name = "Home",
            route = "home",
            icon = Icons.Rounded.Home
        ),
        BottomNavItem(
            name = "Favourite",
            route = "favourite",
            icon = Icons.Rounded.Star
        )
    )
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                screens.forEach {
                    NavigationBarItem(
                        selected = it.route == navBackStackEntry?.destination?.route,
                        onClick = { navController.navigate(it.route) },
                        label = {
                            Text(text = it.name, fontWeight = FontWeight.SemiBold)
                        },
                        icon = {
                            Icon(imageVector = it.icon, contentDescription = "${it.name} Icon")
                        }
                    )
                }
            }
        },
        content = {
            Box(modifier = Modifier.padding(it)) {
                Navigation(navController = navController)
            }
        }
    )
}