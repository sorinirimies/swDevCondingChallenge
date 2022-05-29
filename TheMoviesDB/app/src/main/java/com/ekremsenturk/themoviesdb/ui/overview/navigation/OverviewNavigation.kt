package com.ekremsenturk.themoviesdb.ui.overview.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ekremsenturk.themoviesdb.navigation.NavigationDestination
import com.ekremsenturk.themoviesdb.ui.overview.OverviewRoute

object OverviewDestination : NavigationDestination {
    override val route: String = "overview_route"
    override val destination: String = "overview_destination"
}

fun NavGraphBuilder.overviewGraph(
    navigateToDetails: (String) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = OverviewDestination.route,
        startDestination = OverviewDestination.destination
    ) {
        composable(route = OverviewDestination.destination) {
            OverviewRoute(navigateToDetails = navigateToDetails)
        }
        nestedGraphs()
    }
}