package com.example.dogsapplication.model

import androidx.lifecycle.ViewModel
import com.example.dogsapplication.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class DogsViewModel : ViewModel() {
    val dogs = MutableStateFlow<List<Dog>>(emptyList())

    fun getById(id: String) = dogs.value.first { dog -> dog.id == id }

    init {
        dogs.update {
            mutableListOf(
                Dog(
                    id = "1",
                    name = "Baksic",
                    age = 5,
                    sex = "female",
                    breed = "Pug",
                    avatar = R.drawable.image_1
                ),
                Dog(
                    id = "2",
                    name = "Gold",
                    age = 7,
                    sex = "male",
                    breed = "Doberman ",
                    avatar = R.drawable.image_2
                ),
                Dog(
                    id = "3",
                    name = "Spriks",
                    age = 10,
                    sex = "female",
                    breed = "Chihuahua",
                    avatar = R.drawable.image_3
                ),
                Dog(
                    id = "4",
                    name = "Matilda",
                    age = 4,
                    sex = "male",
                    breed = "French spaniel",
                    avatar = R.drawable.image_4
                ),
                Dog(
                    id = "5",
                    name = "Perfect",
                    age = 5,
                    sex = "male",
                    breed = "Collie",
                    avatar = R.drawable.image_5
                ),
                Dog(
                    id = "6",
                    name = "Weinacht",
                    age = 17,
                    sex = "female",
                    breed = "Bulldog",
                    avatar = R.drawable.image_6
                ),
                Dog(
                    id = "7",
                    name = "Silvia",
                    age = 5,
                    sex = "female",
                    breed = "Poodle",
                    avatar = R.drawable.image_7
                ),
                Dog(
                    id = "8",
                    name = "First",
                    age = 9,
                    sex = "male",
                    breed = "Jack russell terrier",
                    avatar = R.drawable.image_8
                )
            )
        }
    }
}