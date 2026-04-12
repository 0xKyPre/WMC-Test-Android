package at.ac.htl_leonding.wmc_test.wmc_test_example_with_navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyceliumGallery(
    onSelect: (Detail) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Mycelium Gallery",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(Modifier.height(16.dp))

        myceliumList.forEach { item ->
            MyceliumCard(
                item = item,
                onClick = onSelect
            )
        }
    }
}

@Composable
fun MyceliumCard(
    item: MyceliumItem,
    onClick: (Detail) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                onClick(
                    Detail(
                        speciesName = item.title,
                        difficulty = item.difficulty,
                        growTimeDays = item.days,
                        optionalImageResource = item.imageRes
                    )
                )
            }
    ) {
        Column(
            Modifier.padding(16.dp)
        ) {

            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.title,
                modifier = Modifier
                    .height(120.dp)
            )

            Spacer(Modifier.height(8.dp))

            Text(
                item.title,
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                "Difficulty: ${item.difficulty}/5"
            )

            Text(
                "Grow time: ${item.days} days"
            )
        }
    }
}

@Composable
fun DetailScreen(
    detail: Detail,
    onBack: () -> Unit
) {
    var progress by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (detail.optionalImageResource != null && detail.optionalImageResource != 0) {
            Image(
                painter = painterResource(detail.optionalImageResource),
                contentDescription = detail.speciesName
            )
        }

        Text(
            detail.speciesName,
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(Modifier.height(12.dp))

        Text(
            "Difficulty: ${detail.difficulty}/5"
        )

        Text(
            "Grow time: ${detail.growTimeDays} days"
        )

        Spacer(Modifier.height(20.dp))

        Text(
            "Colonization: $progress%"
        )

        Button(
            onClick = {
                if (progress < 100) {
                    progress += 10
                }
            }
        ) {
            Text(
                "Start Growth Simulation"
            )
        }

        Spacer(Modifier.height(20.dp))

        Button(onClick = onBack) {
            Text(
                "Back"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyceliumGalleryPreview() {
    MaterialTheme {
        MyceliumGallery(
            onSelect = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    MaterialTheme {
        DetailScreen(
            detail = Detail(
                speciesName = "Crimson",
                difficulty = 10,
                growTimeDays = 32
            ),
            onBack = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreviewWithImage() {
    MaterialTheme {
        DetailScreen(
            detail = Detail(
                speciesName = "Mycelium",
                difficulty = 2,
                growTimeDays = 14,
                optionalImageResource = R.drawable.mycelium
            ),
            onBack = { }
        )
    }
}