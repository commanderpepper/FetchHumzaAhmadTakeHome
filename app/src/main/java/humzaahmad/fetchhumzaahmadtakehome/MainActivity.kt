package humzaahmad.fetchhumzaahmadtakehome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import humzaahmad.fetchhumzaahmadtakehome.feature.items.ItemsScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(modifier = Modifier.fillMaxSize(),
                navController = navController,
                startDestination = ItemsDestination) {
                composable<ItemsDestination> {
                    ItemsScreen(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}