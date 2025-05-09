package com.example.tmobile.presentations.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.tmobile.presentations.navigation.NavigationNavHost
import com.example.tmobile.ui.theme.TMobileTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // A surface container using the 'background' color from the theme

            TMobileTheme {
                NavigationNavHost(navHostController = rememberNavController())
            }
        }
    }
}

