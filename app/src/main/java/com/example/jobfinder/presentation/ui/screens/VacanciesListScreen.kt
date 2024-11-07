package com.example.jobfinder.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobfinder.R
import com.example.jobfinder.ui.theme.JobFinderTheme

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun VacanciesListScreenPreview() {
    JobFinderTheme {
        VacanciesListScreen()
    }
}

@Composable
fun VacanciesListScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                SearchField(modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.width(8.dp))
                FilterButton()
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "145 вакансий",
                            color = MaterialTheme.colorScheme.onPrimary,
                            style = MaterialTheme.typography.bodyMedium,
                        )
                        ByCorrespondenceButton()
                    }
                }

                items(2) {
                    JobCard(
                        isActive = true,
                        turnFavorite = {},
                        title = "Дизайн для маркетплейсов Wildberries, Ozon",
                        salary = "1500-2100 Br",
                        city = "Минск",
                        company = "Еком дизайн",
                        isChecked = true,
                        experience = "Опыт от 1 до 3 лет",
                        onButtonClick = {}
                    )
                }
            }
        }

        // Extended FAB positioned at the bottom end
        ExtendedFloatingActionButton(
            onClick = { /* Handle map action */ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.map),
                    contentDescription = "Map"
                )
            },
            text = {
                Text(
                    text = "Карта",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.labelLarge
                )
            },
            containerColor = MaterialTheme.colorScheme.surface, // Set background color
            shape = CircleShape, // Set shape
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        )
    }
}

@Composable
fun ByCorrespondenceButton() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "По соответствию",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Spacer(modifier = Modifier.width(3.dp))
        Icon(
            painter = painterResource(id = R.drawable.double_arrow),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(16.dp)
        )
    }
}
