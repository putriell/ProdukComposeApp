package com.example.produkcomposeapp.ui.nav

sealed class Screen(val route:String) {
    object Main : Screen("main")
    object Detail : Screen("main/{produkId}") {
        fun createRoute(produkId: String) = "main/$produkId"
    }
    object Profile : Screen("profile")
}