package at.ac.htl_leonding.wmc_test.wmc_template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import at.ac.htl_leonding.wmc_test.wmc_template.ui.theme.WMCTemplateTheme

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
                            Home(
                                onSelect = { detail ->
                                    backStack.add(detail)
                                }
                            )
                        }

                        entry<Detail> { key ->
                            AnotherScreen(
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WMCTemplateTheme {
        Greeting("Android")
    }
}