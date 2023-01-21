package com.example.dogsapplication.ui.dog


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dogsapplication.R
import com.example.dogsapplication.model.Dog
import com.example.dogsapplication.ui.theme.DogsApplicationTheme

@Composable
fun DogCard(
    dog: Dog,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val padding = 16.dp
    val color = Color(red = 36, green = 37, blue = 46, alpha = 128)
    Column(
        modifier
            .clickable(onClick = onClick)
            .padding(
                top = padding / 2,
                start = padding,
                end = padding,
                bottom = padding / 2
            )
            .fillMaxWidth()
            .background(
                color,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 1.dp,
                color,
                shape = RoundedCornerShape(10.dp)
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth(10f)
                .height(100.dp)
        ) {
            Image(
                painter = painterResource(id = dog.avatar),
                contentDescription = "Avatar",
                modifier
                    .size(90.dp)
                    .padding(
                        top = 2.dp,
                        start = 6.dp,
                        end = 0.dp,
                        bottom = 2.dp
                    )
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.size(padding))
            Column {
                Text(
                    text = dog.name,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
                )
                Text(
                    text = dog.breed,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Light,
                        color = Color.LightGray
                    ),
                )
            }
        }
    }
}

@Preview
@Composable
fun DogCardPreview() {
    val dog = Dog(
        id = "1",
        name = "Baksic",
        age = 5,
        sex = "male",
        breed = "Pug",
        avatar = R.drawable.image_1
    )

    DogsApplicationTheme(darkTheme = true) {
        Surface {
            DogCard(dog, {})
        }
    }
}
