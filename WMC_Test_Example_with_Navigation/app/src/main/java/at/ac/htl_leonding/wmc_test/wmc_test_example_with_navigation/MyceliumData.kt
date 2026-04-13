package at.ac.htl_leonding.wmc_test.wmc_test_example_with_navigation

data class MyceliumItem(
    val title: String,
    val difficulty: Int,
    val days: Int,
    val imageRes: Int
)

val myceliumList = listOf(
    MyceliumItem("Mycelium", 2, 14, R.drawable.mycelium),
    MyceliumItem("Warp", 3, 21, R.drawable.warp),
    MyceliumItem("Crimson", 5, 30, R.drawable.crimson),
    MyceliumItem("Mycelium", 2, 14, R.drawable.mycelium),
    MyceliumItem("Warp", 3, 21, R.drawable.warp),
    MyceliumItem("Crimson", 5, 30, R.drawable.crimson)
)