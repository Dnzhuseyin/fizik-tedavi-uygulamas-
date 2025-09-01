package com.example.fiziktedavi.ui.leaderboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class User(val id: Int, val name: String, val score: Int)

@OptIn(ExperimentalMaterial3Api::class)
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

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sıralama", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(paddingValues)
        ) {
            itemsIndexed(users) { index, user ->
                LeaderboardItem(rank = index + 1, user = user)
            }
        }
    }
}

@Composable
fun LeaderboardItem(rank: Int, user: User) {
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
            Text(
                text = "#$rank",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(16.dp))
            // You can add user avatar here
            // Image(painter = painterResource(id = R.drawable.avatar), contentDescription = null, modifier = Modifier.size(40.dp).clip(CircleShape))
            // Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = user.name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f)
            )
            if (rank <= 3) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Top Rank",
                    tint = when (rank) {
                        1 -> Color(0xFFFFD700) // Gold
                        2 -> Color(0xFFC0C0C0) // Silver
                        else -> Color(0xFFCD7F32) // Bronze
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                text = "${user.score} Puan",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
