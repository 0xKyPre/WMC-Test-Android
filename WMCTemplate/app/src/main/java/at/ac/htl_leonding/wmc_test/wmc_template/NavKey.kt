package at.ac.htl_leonding.wmc_test.wmc_template

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object Home : NavKey

@Serializable
data class Detail(
    val variable: String
) : NavKey
