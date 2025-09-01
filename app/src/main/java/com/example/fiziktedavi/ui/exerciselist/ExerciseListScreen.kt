package com.example.fiziktedavi.ui.exerciselist

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class Exercise(val id: Int, val name: String, val description: String, val isSelected: MutableState<Boolean>)

@OptIn(ExperimentalMaterial3Api::class)
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
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO: Add new exercise */ }) {
                Icon(Icons.Default.Add, contentDescription = "Add new exercise")
            }
        }
    ) { paddingValues ->
        if (exercises.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(Icons.Default.FitnessCenter, contentDescription = "No exercises", modifier = Modifier.size(64.dp))
                Spacer(modifier = Modifier.height(16.dp))
                Text("Henüz egzersiz yok.", style = MaterialTheme.typography.headlineSmall)
            }
        } else {
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
}

@Composable
fun ExerciseItem(exercise: Exercise) {
    val scale by animateFloatAsState(if (exercise.isSelected.value) 1.1f else 1.0f)

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
            Icon(Icons.Default.FitnessCenter, contentDescription = null, modifier = Modifier.size(32.dp))
            Spacer(modifier = Modifier.width(16.dp))
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
                ),
                modifier = Modifier.scale(scale)
            )
        }
    }
}
