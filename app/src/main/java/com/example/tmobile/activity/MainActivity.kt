package com.example.tmobile.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.tmobile.navigation.NavigationNavHost
import com.example.tmobile.ui.theme.TMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                // A surface container using the 'background' color from the theme

            TMobileTheme {
                    NavigationNavHost(navHostController = rememberNavController(),    )

            }
        }
    }
}

