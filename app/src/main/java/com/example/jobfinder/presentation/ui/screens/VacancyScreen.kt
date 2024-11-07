package com.example.jobfinder.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jobfinder.R
import com.example.jobfinder.presentation.viewmodel.MainViewModel
import com.example.jobfinder.ui.theme.JobFinderTheme
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun VacancyPreview() {
    JobFinderTheme {
        VacancyScreen()
    }
}

@Composable
fun VacancyScreen() {
    CustomNavBar()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        Text(
            text = "UX/UI Designer",
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(end = 20.dp)
        )

        Text(
            text = "Уровень дохода не указан",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Text(
            text = "Требуемый опыт: от 1 года до 3 лет",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Text(
            text = "Полная занятость, полный день",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp), // Отступы между текстом и карточками
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ProfileInfoCard(modifier = Modifier.weight(1f))
            ProfileInfoCard(modifier = Modifier.weight(1f))
        }
        Text(
            text = "MOBYRIX - динамично развивающаяся продуктовая " +
                    "IT-компания, специализирующаяся на разработке " +
                    "мобильных приложений для iOS и Android. Наша " +
                    "команда работает над собственными продуктами в " +
                    "разнообразных сферах: от утилит до развлечений и " +
                    "бизнес-приложений.\n" +
                    "Мы ценим талант и стремление к инновациям и в " +
                    "данный момент в поиске талантливого UX/UI " +
                    "Designer, готового присоединиться к нашей команде " +
                    "и внести значимый вклад в развитие наших " +
                    "проектов.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}


@Composable
fun ProfileInfoCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        shape = MaterialTheme.shapes.small
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Ваш текст здесь",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.align(Alignment.CenterStart)
            )
            Box(
                modifier = Modifier
                    .size(20.dp) // Уменьшаем размер кружка
                    .background(
                        color = MaterialTheme.colorScheme.secondary,
                        shape = CircleShape
                    )
                    .align(Alignment.TopEnd), // Размещаем в верхнем правом углу
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Профиль",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(12.dp) // Уменьшаем размер иконки
                )
            }
        }
    }
}




@Composable
fun CustomNavBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { /* Обработка нажатия на кнопку назад */ },
            modifier = Modifier.padding(end = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "Назад",
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
        Spacer(modifier = Modifier.weight(1f)) // Добавляем Spacer для выравнивания остальных кнопок вправо
        IconButton(
            onClick = { /* Обработка нажатия на кнопку глаз */ }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.eye),
                contentDescription = "Просмотр",
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
        IconButton(
            onClick = { /* Обработка нажатия на кнопку поделиться */ },
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.share),
                contentDescription = "Поделиться",
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
        FavoriteButton(
            modifier = Modifier
                .size(42.dp)
                .padding(horizontal = 8.dp),
            isActive = true,
            turnFavorite = {}
        )
    }
}

@Composable
fun YandexMapBanner() {
    AndroidView(
        factory = { context ->
            // Создаем MapView
            val mapView = MapView(context)
            mapView.map.move(
                CameraPosition(Point(55.751244, 37.618423), 11.0f, 0.0f, 0.0f)
            )
            mapView
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp) // Устанавливаем высоту баннера
    )
}


