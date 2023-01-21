package com.example.dogsapplication.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dogsapplication.R
import com.example.dogsapplication.model.Dog
import com.example.dogsapplication.ui.theme.DogsApplicationTheme


@Composable
fun DogProfile(
    dog: Dog,
    modifier: Modifier = Modifier,
) {
    Surface(modifier = modifier.fillMaxSize()) {
        LazyColumn() {
            item { ProfileHeader(avatar = dog.avatar) }
            item {
                Text(
                    text = dog.name,
                    style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.Medium),
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    textAlign = TextAlign.Left
                )
            }
            item { Element("Breed", dog.breed) }
            item { Element("Age(month)", dog.age.toString()) }
            item { Element("Sex", dog.sex) }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp)
                        .size(100.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    Button(onClick = {}) {
                        Text(text = "Adopt Me")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ParrotProfilePreview() {
    val dog = Dog(
        id = "1",
        name = "Baksic",
        age = 5,
        sex = "male",
        breed = "Pug",
        avatar = R.drawable.image_1
    )
    DogsApplicationTheme(darkTheme = true) {
        DogProfile(dog = dog)
    }
}
