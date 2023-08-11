package com.emirhanemmez.feature.detail.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.emirhanemmez.feature.detail.presentation.component.Item
import com.emirhanemmez.feature.detail.presentation.data.DetailItem

@Composable
fun DetailScreen(detailItem: DetailItem) {
    Box(modifier = Modifier.fillMaxSize()) {
        Item(detailItem = detailItem)
    }
}
