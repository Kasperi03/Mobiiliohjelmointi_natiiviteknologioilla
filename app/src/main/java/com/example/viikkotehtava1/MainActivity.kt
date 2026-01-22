package com.example.viikkotehtava1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.viikkotehtava1.screens.HomeScreen
import com.example.viikkotehtava1.ui.theme.Viikkotehtava1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Viikkotehtava1Theme {
                Surface {
                    HomeScreen()
                }
            }
        }
    }
}

