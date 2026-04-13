package at.ac.htl_leonding.wmc_test.wmc_template

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Home(
    onSelect: (Detail) -> Unit
) {
    Text("Home")
}

@Composable
fun AnotherScreen(
    detail: Detail,
    onBack: () -> Unit
) {
    Text("Variable: ")
    Text(detail.variable)
}