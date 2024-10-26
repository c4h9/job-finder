package com.example.jobfinder.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jobfinder.presentation.viewmodel.MainViewModel
import com.example.jobfinder.ui.theme.JobFinderTheme

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun JobPreview() {
    JobFinderTheme {
        val viewModel: MainViewModel = viewModel()
        MainScreen(viewModel)
    }
}

@Composable
fun MainScreen(viewModel: Any) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .weight(1f)
                    .background(Color.DarkGray)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = { /* Handle filter */ }) {
                Icon(
                    imageVector = Icons.Default.FilterList,
                    contentDescription = "Filter",
                    tint = Color.White
                )
            }
        }

        // Horizontal scrollable cards
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(bottom = 16.dp)
        ) {
            CardItem("Вакансии рядом с вами")
            CardItem("Поднять резюме в поиске")
            CardItem("Временная работа и подработка")
        }

        Text(
            text = "Вакансии для вас",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        JobCard(
            title = "UI/UX Designer",
            location = "Минск",
            company = "Мобирикс",
            experience = "Опыт от 1 года до 3 лет",
            date = "Опубликовано 20 февраля",
            viewers = 1
        )

        Spacer(modifier = Modifier.height(16.dp))

        JobCard(
            title = "Дизайнер для маркетплейсов Wildberries, Ozon",
            location = "Минск",
            company = "Еком дизайн",
            experience = "Опыт от 1 года до 3 лет",
            date = "Опубликовано 16 февраля",
            viewers = 7,
            salary = "1500-2900 Br"
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Еще 143 вакансии", color = Color.White)
        }
    }
}

@Composable
fun CardItem(title: String) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(100.dp)
            .background(Color.DarkGray)
            .padding(8.dp)
            .padding(end = 8.dp)
    ) {
        Text(
            text = title,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
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
                onClick = {  },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Откликнуться", color = Color.White)
            }
        }
    }
}