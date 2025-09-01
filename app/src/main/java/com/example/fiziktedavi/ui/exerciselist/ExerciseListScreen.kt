package com.example.fiziktedavi.ui.exerciselist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Exercise(val id: Int, val name: String, val description: String)

@Composable
fun ExerciseListScreen() {
    val exercises = remember {
        listOf(
            Exercise(1, "Diz Bükme", "Yavaşça dizinizi bükün ve düzeltin."),
            Exercise(2, "Omuz Kaldırma", "Omuzlarınızı yavaşça yukarı kaldırın ve indirin."),
            Exercise(3, "Ayak Bileği Döndürme", "Ayak bileğinizi saat yönünde ve tersi yönde çevirin."),
            Exercise(4, "Kol Germe", "Kolunuzu göğsünüze doğru gerin."),
            Exercise(5, "Bacak Kaldırma", "Sırt üstü yatarken bacağınızı düz bir şekilde kaldırın.")
        )
    }
    val selectedExercises = remember { mutableStateListOf<Exercise>() }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Egzersiz Seçimi", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(exercises) { exercise ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = selectedExercises.contains(exercise),
                        onCheckedChange = {
                            if (it) {
                                selectedExercises.add(exercise)
                            } else {
                                selectedExercises.remove(exercise)
                            }
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(text = exercise.name, style = MaterialTheme.typography.bodyLarge)
                        Text(text = exercise.description, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* TODO: Save selected exercises */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Seçilenleri Kaydet")
        }
    }
}
