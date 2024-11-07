package com.example.jobfinder.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jobfinder.Screen
import com.example.jobfinder.presentation.ui.screens.FavoritesScreen
import com.example.jobfinder.presentation.ui.screens.LoginScreen
import com.example.jobfinder.presentation.ui.screens.MainScreen
import com.example.jobfinder.presentation.ui.screens.VacanciesListScreen
import com.example.jobfinder.presentation.ui.screens.ProfileScreen
import com.example.jobfinder.presentation.ui.screens.ResponsesScreen
import com.example.jobfinder.presentation.ui.screens.VacancyScreen
import com.example.jobfinder.presentation.ui.screens.VerificationScreen
import com.example.jobfinder.presentation.viewmodel.MainViewModel

@Composable
fun NavigationGraph(
    navController: NavHostController,
    viewModel: MainViewModel
) {
    val isLogin by viewModel.isLogin.collectAsState()

    val startDestination = if (isLogin == false) {
        Screen.Login.route
    } else {
        Screen.Main.route
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Favorites.route) {
            FavoritesScreen()
        }
        composable(Screen.Login.route) {
            LoginScreen()
        }
        composable(Screen.Main.route) {
            VacancyScreen()//MainScreen()
        }
        composable(Screen.VacanciesList.route) {
            VacanciesListScreen()
        }
        composable(Screen.Profile.route) {
            ProfileScreen()
        }
        composable(Screen.Responses.route) {
            ResponsesScreen()
        }
        composable(Screen.Vacancy.route) {
            VacancyScreen()
        }
        composable(Screen.Verification.route) {
            VerificationScreen()
        }
    }
}





