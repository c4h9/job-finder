package com.example.jobfinder.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jobfinder.R
import com.example.jobfinder.ui.theme.JobFinderTheme

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun JobPreview() {
    JobFinderTheme {
        MainScreen()
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
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
                HintsCarousel()
            }

            item {
                Text(
                    text = "Вакансии для вас",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier.padding(16.dp),
                )
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

            item {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    shape = MaterialTheme.shapes.small,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Text(
                        text = "Ещё 143 вакансии",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

@Composable
fun HintsCarousel() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(start = 16.dp, bottom = 16.dp)
    ) {
        CardItem(modifier = Modifier, MaterialTheme.colorScheme.primaryContainer, iconTint = MaterialTheme.colorScheme.primary)
        CardItem(modifier = Modifier, MaterialTheme.colorScheme.secondaryContainer, painterResource(id = R.drawable.star), MaterialTheme.colorScheme.secondary, "Поднять резюме в поиске", "Поднять", onTextClick = {})
        CardItem(modifier = Modifier, MaterialTheme.colorScheme.secondaryContainer, painterResource(id = R.drawable.plan), MaterialTheme.colorScheme.secondary, "Временная работа и подработка")
    }
}

@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    circleColor: Color = Color.Blue,
    icon: Painter = painterResource(id = R.drawable.map),
    iconTint: Color = Color.White,
    text: String = "Вакансии рядом с вами",
    clickableText: String = "Clickable Text",
    onTextClick: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .width(150.dp)
            .height(100.dp)
            .padding(end = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Box(
                modifier = modifier
                    .size(24.dp)
                    .background(circleColor, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = icon,
                    contentDescription = "Icon",
                    tint = iconTint,
                    modifier = modifier.size(16.dp)
                )
            }

            Text(
                text = text,
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodyLarge,
                modifier = modifier.padding(top = 8.dp)
            )

            onTextClick?.let {
                Text(
                    text = clickableText,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = modifier.clickable { it() }
                )
            }
        }
    }
}



@Composable
fun JobCard(
    title: String,
    location: String,
    company: String,
    experience: String,
    date: String,
    viewers: Int,
    salary: String? = null
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = "Сейчас просматривает $viewers человек",
                color = Color.Green,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$location\n$company",
                color = Color.White,
                fontSize = 14.sp
            )
            salary?.let {
                Text(
                    text = it,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = experience,
                color = Color.White,
                fontSize = 14.sp
            )
            Text(
                text = date,
                color = Color.White,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "Откликнуться",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
fun SearchField(modifier: Modifier) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Box(
        modifier = modifier
            .height(56.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.small
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        BasicTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            textStyle = MaterialTheme.typography.displaySmall.copy(
                color = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
        )
        if (textState.value.text.isEmpty()) {
            Text(
                text = "Поиск по вакансиям",
                style = MaterialTheme.typography.displaySmall.copy(
                    color = MaterialTheme.colorScheme.tertiary
                ),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun FavoriteButton(modifier: Modifier, isActive: Boolean, turnFavorite: () -> Unit) {

    val iconResource = if (isActive) {
        R.drawable.active_heart
    } else {
        R.drawable.unactive_heart
    }

    Image(
        painter = painterResource(id = iconResource),
        contentDescription = if (isActive) "Active Heart" else "Inactive Heart",
        modifier = modifier
            .size(20.dp)
            .clickable {
                turnFavorite()
            }
    )
}

@Composable
fun FilterButton() {
    IconButton(
        modifier = Modifier
            .size(56.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.small
            ),
        onClick = { /* Handle filter */ }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.filter),
            contentDescription = "Filter",
            tint = Color.White
        )
    }
}

@Composable
fun JobCard(
    viewers: String = "0",
    isActive: Boolean = false,
    turnFavorite: () -> Unit,
    title: String? = null,
    salary: String? = null,
    city: String? = null,
    company: String? = null,
    isChecked: Boolean = false,
    experience: String? = null,
    date: String = "20 февраля",
    onButtonClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Сейчас просматривает $viewers человек",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.secondary
                )
                FavoriteButton(Modifier, isActive, turnFavorite)
            }
            title?.let{
                Text(
                    text = title,
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(end = 20.dp)
                )
            }
            salary?.let{
                Text(
                    text = salary,
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            city?.let{
                Text(
                    text = city,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            company?.let{
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = company,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    if (isChecked) {
                        Icon(
                            painter = painterResource(id = R.drawable.check_mark),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
            experience?.let {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.resource_case),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = experience,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
            Text(
                text = "Опубликовано $date",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.tertiary
            )
            Button(
                onClick = { onButtonClick() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "Откликнуться",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}