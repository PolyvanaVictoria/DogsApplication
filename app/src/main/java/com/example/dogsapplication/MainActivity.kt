package com.example.dogsapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dogsapplication.model.DogsViewModel
import com.example.dogsapplication.ui.feed.Feed
import com.example.dogsapplication.ui.profile.DogProfile
import com.example.dogsapplication.ui.theme.DogsApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: DogsViewModel by viewModels()
        setContent {
            DogsApplicationTheme(darkTheme = true) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(viewModel)
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: DogsViewModel) {
    val state by viewModel.dogs.collectAsState()
    var selectedId by remember {
        mutableStateOf<String?>(value = null)
    }
    Crossfade(targetState = selectedId) { id ->
        if (id == null) {
            Feed(dogs = state, onSelected = { dog ->
                selectedId = dog.id
            })
        } else {
            DogProfile(dog = viewModel.getById(id))
            BackHandler() {
                selectedId = null
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DogsApplicationTheme(darkTheme = true) {
        MainScreen(DogsViewModel())
    }
}