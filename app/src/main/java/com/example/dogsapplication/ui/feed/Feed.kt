package com.example.dogsapplication.ui.feed


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dogsapplication.R
import com.example.dogsapplication.model.Dog
import com.example.dogsapplication.ui.dog.DogCard
import androidx.compose.foundation.lazy.items
import com.example.dogsapplication.ui.theme.DogsApplicationTheme

@Composable
fun Feed(
    dogs: List<Dog>,
    onSelected: (Dog) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier.fillMaxSize()) {
        LazyColumn() {
            items(dogs) { dog ->
                DogCard(dog = dog, onClick = { onSelected(dog) })
            }
        }
    }
}

@Preview
@Composable
fun FeedPreview() {
    val dog = Dog(
        id = "1",
        name = "Baksic",
        age = 5,
        sex = "male",
        breed = "Pug",
        avatar = R.drawable.image_1
    )
    DogsApplicationTheme(darkTheme = true) {
        Feed(dogs = listOf(dog), onSelected = {})
    }
}