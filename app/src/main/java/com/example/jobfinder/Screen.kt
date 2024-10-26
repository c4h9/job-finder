package com.example.jobfinder

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Favorites : Screen("favorites", "Избранное", Icons.Default.Favorite)
    object Login : Screen("login", "Вход", Icons.Default.Search)
    object Main : Screen("search", "Поиск", Icons.Default.Search)
    object Messages : Screen("messages", "Сообщения", Icons.Default.Message)
    object Profile : Screen("profile", "Профиль", Icons.Default.Person)
    object Responses : Screen("responses", "Отклики", Icons.Default.Email)
    object Vacancy : Screen("vacancy", "Вакансии", Icons.Default.Search)
    object Verification : Screen("verification", "Верификация", Icons.Default.Search)
}
