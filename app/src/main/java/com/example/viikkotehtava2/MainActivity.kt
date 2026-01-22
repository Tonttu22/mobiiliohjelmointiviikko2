package com.example.viikkotehtava2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.viikkotehtava2.uuii.HomeScreen
import com.example.viikkotehtava2.ui.theme.Viikkotehtava2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Viikkotehtava2Theme {
                HomeScreen()
            }
        }
    }
}
