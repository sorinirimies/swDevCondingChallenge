package com.ekremsenturk.themoviesdb.navigation

/**
 * Interface for describing the The Movies DB navigation destinations
 */
interface NavigationDestination {
    val route: String
    val destination: String
}