package com.example.dogsapplication.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dogsapplication.R
import com.example.dogsapplication.model.Dog
import com.example.dogsapplication.ui.theme.DogsApplicationTheme

@Composable
fun Element(
    elementName: String,
    elementValue: String,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier.fillMaxWidth()) {
        val padding = 20.dp
        Column(
            modifier
                .fillMaxWidth()
                .padding(
                    top = padding / 2,
                    start = padding,
                    end = padding,
                    bottom = padding / 2
                )
        ) {
            Text(
                text = elementName,
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Light)
            )
            Text(
                text = elementValue,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold)
            )
            Divider(
                color = Color.LightGray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 1.dp,
                        end = 5.dp,
                        top = 1.dp,
                        bottom = 3.dp
                    )
            )
        }
    }
}

@Preview
@Composable
fun ElementPreview() {
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
            Element("Age(month)", dog.age.toString())

        }
    }
}
