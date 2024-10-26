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
import com.example.jobfinder.presentation.ui.screens.MessagesScreen
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
            FavoritesScreen(viewModel)
        }
        composable(Screen.Login.route) {
            LoginScreen(viewModel)
        }
        composable(Screen.Main.route) {
            MainScreen(viewModel)
        }
        composable(Screen.Messages.route) {
            MessagesScreen(viewModel)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(viewModel)
        }
        composable(Screen.Responses.route) {
            ResponsesScreen(viewModel)
        }
        composable(Screen.Vacancy.route) {
            VacancyScreen(viewModel)
        }
        composable(Screen.Verification.route) {
            VerificationScreen(viewModel)
        }
    }
}





