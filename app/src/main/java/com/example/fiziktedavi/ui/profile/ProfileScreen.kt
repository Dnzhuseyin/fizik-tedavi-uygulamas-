package com.example.fiziktedavi.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Profil", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Profile Picture",
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Hüseyin Deniz", style = MaterialTheme.typography.headlineSmall)
        Text(text = "huseyin.deniz@example.com", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Toplam Egzersiz", style = MaterialTheme.typography.bodyLarge)
                Text(text = "125", style = MaterialTheme.typography.headlineMedium)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Haftalık Seri", style = MaterialTheme.typography.bodyLarge)
                Text(text = "5 gün", style = MaterialTheme.typography.headlineMedium)
            }
        }
    }
}
