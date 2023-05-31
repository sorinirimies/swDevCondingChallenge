package de.pirrung.tmbd.challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import de.pirrung.tmbd.challenge.presentation.overview.MovieOverviewScreen
import de.pirrung.tmbd.challenge.presentation.overview.components.OverviewTopAppBar
import de.pirrung.tmbd.challenge.presentation.ui.theme.TMDBCodingChallengeTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TMDBCodingChallengeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
                    Scaffold(
                        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                        topBar = {
                            OverviewTopAppBar(scrollBehavior = scrollBehavior)
                        }
                    ) { padding ->
                        MovieOverviewScreen(
                            modifier = Modifier
                                .padding(padding)
                                .fillMaxSize()
                                .padding(start = 15.dp, end = 15.dp)
                        )
                    }
                }
            }
        }
    }
}