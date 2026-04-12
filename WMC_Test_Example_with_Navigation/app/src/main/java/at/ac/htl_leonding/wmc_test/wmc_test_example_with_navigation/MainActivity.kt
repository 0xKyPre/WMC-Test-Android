package at.ac.htl_leonding.wmc_test.wmc_test_example_with_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val backStack = rememberNavBackStack(Home)

            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                NavDisplay(
                    backStack = backStack,
                    onBack = { backStack.removeLastOrNull() },
                    modifier = Modifier.padding(innerPadding),
                    entryProvider = entryProvider {

                        entry<Home> {
                            MyceliumGallery(
                                onSelect = { detail ->
                                    backStack.add(detail)
                                }
                            )
                        }

                        entry<Detail> { key ->
                            DetailScreen(
                                detail = key,
                                onBack = { backStack.removeLastOrNull() }
                            )
                        }
                    }
                )
            }
        }
    }
}