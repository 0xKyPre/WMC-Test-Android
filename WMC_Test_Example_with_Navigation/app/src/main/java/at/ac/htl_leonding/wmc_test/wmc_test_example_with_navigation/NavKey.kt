package at.ac.htl_leonding.wmc_test.wmc_test_example_with_navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object Home : NavKey

@Serializable
data class Detail(
    val speciesName: String,
    val difficulty: Int,
    val growTimeDays: Int,
    val optionalImageResource: Int? = null
) : NavKey
