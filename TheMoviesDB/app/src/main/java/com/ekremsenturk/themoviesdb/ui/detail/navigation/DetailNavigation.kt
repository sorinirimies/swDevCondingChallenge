package com.ekremsenturk.themoviesdb.ui.detail.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ekremsenturk.themoviesdb.navigation.NavigationDestination
import com.ekremsenturk.themoviesdb.ui.detail.DetailRoute

object DetailDestination : NavigationDestination {
    override val route: String = "detail_route"
    override val destination: String = "detail_destination"
    const val movieIdArg = "movieId"
}

fun NavGraphBuilder.detailGraph(
    onItemClick: (Int) -> Unit,
    onBackClick: () -> Unit
) {
    composable(
        route = "${DetailDestination.route}/{${DetailDestination.movieIdArg}}",
        arguments = listOf(
            navArgument(DetailDestination.movieIdArg) {
                type = NavType.IntType
            }
        )
    ) {
        DetailRoute(
            onItemClick = onItemClick,
            onBackClick = onBackClick,
            movieId = it.arguments!!.getInt(DetailDestination.movieIdArg)
        )
    }
}