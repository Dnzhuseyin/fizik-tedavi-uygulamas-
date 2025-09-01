package com.example.fiziktedavi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.fiziktedavi.ui.navigation.Navigation
import com.example.fiziktedavi.ui.theme.FizikTedaviTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FizikTedaviTheme {
                Navigation()
            }
        }
    }
}