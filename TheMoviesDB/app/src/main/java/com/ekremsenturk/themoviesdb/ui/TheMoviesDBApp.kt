package com.ekremsenturk.themoviesdb.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.ekremsenturk.themoviesdb.ui.detail.navigation.DetailDestination
import com.ekremsenturk.themoviesdb.ui.detail.navigation.detailGraph
import com.ekremsenturk.themoviesdb.ui.overview.navigation.OverviewDestination
import com.ekremsenturk.themoviesdb.ui.overview.navigation.overviewGraph

@Composable
fun TheMoviesDBApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = OverviewDestination.route) {
        overviewGraph(
            navigateToDetails = { navController.navigate("${DetailDestination.route}/$it") },
            nestedGraphs = {
                detailGraph(
                    onItemClick = { navController.navigate("${DetailDestination.route}/$it") },
                    onBackClick = { navController.popBackStack() })
            }
        )
    }
}