package com.example.fiziktedavi.ui.leaderboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class User(val id: Int, val name: String, val score: Int)

@Composable
fun LeaderboardScreen() {
    val users = remember {
        listOf(
            User(1, "Hüseyin", 1500),
            User(2, "Ayşe", 1400),
            User(3, "Fatma", 1250),
            User(4, "Mehmet", 1100),
            User(5, "Ali", 950)
        ).sortedByDescending { it.score }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Liderlik Tablosu", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            itemsIndexed(users) { index, user ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "${index + 1}.", style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = user.name, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
                    Text(text = "${user.score} Puan", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}
