package com.example.viikkotehtava1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.viikkotehtava1.navigation.ROUTE_CALENDAR
import com.example.viikkotehtava1.navigation.ROUTE_HOME
import com.example.viikkotehtava1.ui.theme.Viikkotehtava1Theme
import com.example.viikkotehtava1.view.CalendarScreen
import com.example.viikkotehtava1.view.HomeScreen
import com.example.viikkotehtava1.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            val taskViewModel: TaskViewModel = viewModel()

            Viikkotehtava1Theme {
                Scaffold { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = ROUTE_HOME
                    ) {

                        composable(ROUTE_HOME) {
                            HomeScreen(
                                viewModel = taskViewModel,
                                onNavigateCalendar = {
                                    navController.navigate(ROUTE_CALENDAR)
                                }
                            )
                        }

                        composable(ROUTE_CALENDAR) {
                            CalendarScreen(
                                navController = navController,
                                viewModel = taskViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}


