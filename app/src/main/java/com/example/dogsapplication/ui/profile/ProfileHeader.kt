package com.example.dogsapplication.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dogsapplication.R
import com.example.dogsapplication.ui.theme.DogsApplicationTheme


@Composable
fun ProfileHeader(avatar: Int) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
    )
    {
        Image(
            alignment = Alignment.TopCenter,
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            painter = painterResource(id = avatar),
        )
    }
}

@Preview
@Composable
fun ProfileHeaderPreview() {
    DogsApplicationTheme(darkTheme = true) {
        ProfileHeader(avatar = R.drawable.image_1)
    }
}
