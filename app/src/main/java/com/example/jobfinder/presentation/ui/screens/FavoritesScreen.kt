package com.example.jobfinder.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobfinder.ui.theme.JobFinderTheme

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FavoritesPreview() {
    JobFinderTheme {
        val sampleFavorites = listOf(
            "Избранный элемент 1",
            "Избранный элемент 2",
            "Избранный элемент 3"
        )
        FavoritesScreen()
    }
}

@Composable
fun FavoritesScreen() { //()
    val favorites: List<String> = listOf(
        "Избранный элемент 1",
        "Избранный элемент 2",
        "Избранный элемент 3"
    )
    Column(
        modifier = Modifier.run {
            fillMaxSize()
                .padding(16.dp)
        }
    ) {
        Text(
            text = "Избранное",
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(favorites) { favorite ->
                FavoriteItem(favorite)
            }
        }
    }
}

@Composable
fun FavoriteItem(item: String) {
    Card(
        modifier = Modifier

            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = item,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = { /*  */ }) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Удалить из избранного"
                )
            }
        }
    }
}
