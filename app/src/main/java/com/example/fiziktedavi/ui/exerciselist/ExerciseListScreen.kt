package com.example.fiziktedavi.ui.exerciselist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class Exercise(val id: Int, val name: String, val description: String, val isSelected: MutableState<Boolean>)

@Composable
fun ExerciseListScreen() {
    val exercises = remember {
        mutableStateListOf(
            Exercise(1, "Diz Bükme", "Yavaşça dizinizi bükün ve düzeltin.", mutableStateOf(false)),
            Exercise(2, "Omuz Kaldırma", "Omuzlarınızı yavaşça yukarı kaldırın ve indirin.", mutableStateOf(false)),
            Exercise(3, "Ayak Bileği Döndürme", "Ayak bileğinizi saat yönünde ve tersi yönde çevirin.", mutableStateOf(false)),
            Exercise(4, "Kol Germe", "Kolunuzu göğsünüze doğru gerin.", mutableStateOf(false)),
            Exercise(5, "Bacak Kaldırma", "Sırt üstü yatarken bacağınızı düz bir şekilde kaldırın.", mutableStateOf(false))
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Egzersizler", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(exercises) { exercise ->
                    ExerciseItem(exercise = exercise)
                }
            }
        }
    }
}

@Composable
fun ExerciseItem(exercise: Exercise) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = exercise.name, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = exercise.description, style = MaterialTheme.typography.bodyMedium)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Checkbox(
                checked = exercise.isSelected.value,
                onCheckedChange = { exercise.isSelected.value = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}
