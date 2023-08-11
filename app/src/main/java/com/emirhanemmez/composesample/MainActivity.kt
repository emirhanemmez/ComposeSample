package com.emirhanemmez.composesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.emirhanemmez.composesample.ui.theme.ComposeSampleTheme
import com.emirhanemmez.navigation.component.BottomNavigationBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSampleTheme {
                BottomNavigationBar()
            }
        }
    }
}
