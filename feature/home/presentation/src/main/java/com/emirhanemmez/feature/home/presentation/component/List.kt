package com.emirhanemmez.feature.home.presentation.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.emirhanemmez.feature.home.presentation.model.HomeListItem

@Composable
fun List(
    listItems: List<HomeListItem>,
    onItemClick: (HomeListItem) -> Unit,
    onItemLongClick: (HomeListItem) -> Unit
) {
    LazyColumn(
        Modifier
            .padding(top = 72.dp)
            .testTag(HomeTag.list)
    ) {
        items(listItems) { item ->
            HomeListItem(
                homeListItem = item,
                onItemClick = onItemClick,
                onItemLongClick = onItemLongClick
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeListItem(
    homeListItem: HomeListItem,
    onItemClick: (HomeListItem) -> Unit,
    onItemLongClick: (HomeListItem) -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .combinedClickable(
                onClick = { onItemClick(homeListItem) },
                onLongClick = { onItemLongClick(homeListItem) }
            )
            .background(Color.LightGray)
            .padding(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(200.dp)
                    .testTag(HomeTag.listItemImage),
                contentScale = ContentScale.FillBounds,
                painter = rememberAsyncImagePainter(homeListItem.imageURL),
                contentDescription = "Image of the pokemon"
            )
            Text(
                modifier = Modifier
                    .padding(0.dp, 10.dp, 0.dp, 0.dp)
                    .testTag(HomeTag.listItemName),
                text = homeListItem.name,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}