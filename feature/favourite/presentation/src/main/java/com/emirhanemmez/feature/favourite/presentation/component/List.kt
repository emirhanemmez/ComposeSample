package com.emirhanemmez.feature.favourite.presentation.component

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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.emirhanemmez.feature.favourite.presentation.data.FavouriteItem

@Composable
fun List(
    modifier: Modifier = Modifier,
    listItems: List<FavouriteItem>,
    onItemClick: (FavouriteItem) -> Unit,
    onItemLongClick: (FavouriteItem) -> Unit
) {
    LazyColumn(modifier) {
        items(listItems) { item ->
            ListItem(listItem = item, onItemClick = onItemClick, onItemLongClick = onItemLongClick)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListItem(
    listItem: FavouriteItem,
    onItemClick: (FavouriteItem) -> Unit,
    onItemLongClick: (FavouriteItem) -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .combinedClickable(
                onClick = { onItemClick(listItem) },
                onLongClick = { onItemLongClick(listItem) }
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
                    .requiredHeight(200.dp),
                contentScale = ContentScale.FillBounds,
                painter = rememberAsyncImagePainter(listItem.imageURL),
                contentDescription = "Image of the pokemon"
            )
            Text(
                modifier = Modifier
                    .padding(0.dp, 10.dp, 0.dp, 0.dp),
                text = listItem.name,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}