package com.example.produkcomposeapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.produkcomposeapp.ui.detail.DetailScreen
import com.example.produkcomposeapp.ui.main.MainScreen
import com.example.produkcomposeapp.ui.nav.Screen
import com.example.produkcomposeapp.ui.profile.ProfileScreen

@Composable
fun SkinProdukApp(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route,
    ) {
        composable(Screen.Main.route) {
            MainScreen(
                navigationToProfile = {
                    navController.navigate(Screen.Profile.route)
                },
                navigationToDetail = { produkId ->
                    navController.navigate(Screen.Detail.createRoute(produkId))
                }
            )
        }
        composable(Screen.Profile.route) {
            ProfileScreen(onBackClick = { navController.navigateUp() })
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("produkId") { type = NavType.StringType}),
        ) {
            val id = it.arguments?.getString("produkId") ?: "0"
            DetailScreen(
                produkId = id,
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}