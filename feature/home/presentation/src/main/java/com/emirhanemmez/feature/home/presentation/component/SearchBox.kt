package com.emirhanemmez.feature.home.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.emirhanemmez.feature.home.presentation.HomeTag

@Composable
fun SearchBox(modifier: Modifier = Modifier, onTextChanged: (String) -> Unit) {
    val searchValue = rememberSaveable { mutableStateOf("") }
    Box(modifier = modifier) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .testTag(HomeTag.searchBox),
            value = searchValue.value,
            onValueChange = {
                searchValue.value = it
                onTextChanged.invoke(it)
            },
            label = { Text("Search...") })
    }
}