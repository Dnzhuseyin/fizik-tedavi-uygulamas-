package com.example.fiziktedavi.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fiziktedavi.ui.exerciselist.ExerciseListScreen
import com.example.fiziktedavi.ui.leaderboard.LeaderboardScreen
import com.example.fiziktedavi.ui.login.LoginScreen
import com.example.fiziktedavi.ui.profile.ProfileScreen
import com.example.fiziktedavi.ui.register.RegisterScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController = navController) }
        composable("register") { RegisterScreen(navController = navController) }
        composable("main") { MainScreen() }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.ExerciseList.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(BottomNavItem.ExerciseList.route) { ExerciseListScreen() }
            composable(BottomNavItem.Leaderboard.route) { LeaderboardScreen() }
            composable(BottomNavItem.Profile.route) { ProfileScreen() }
        }
    }
}
