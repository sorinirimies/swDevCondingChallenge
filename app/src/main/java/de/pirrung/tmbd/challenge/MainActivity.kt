package de.pirrung.tmbd.challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.pirrung.tmbd.challenge.core.Route
import de.pirrung.tmbd.challenge.presentation.overview.MovieOverviewScreen
import de.pirrung.tmbd.challenge.presentation.ui.theme.TMDBCodingChallengeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("TEST: ${BuildConfig.TMDB_API_KEY}")
        setContent {
            TMDBCodingChallengeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Route.OVERVIEW
                    ) {
                        composable(Route.OVERVIEW) {
                            MovieOverviewScreen()
                        }
                    }
                }
            }
        }
    }
}