package com.example.viikkotehtava1.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.viikkotehtava1.viewmodel.TaskViewModel
import com.example.viikkotehtava1.model.Task
import androidx.compose.material.icons.automirrored.filled.ArrowBack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen(
    navController: NavController,
    viewModel: TaskViewModel
) {
    val tasks by viewModel.tasks.collectAsState()
    val groupedTasks: Map<String, List<Task>> = tasks.groupBy { it.dueDay.toString() }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        TopAppBar(
            title = { Text("Calendar") },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        )

        LazyColumn {
            groupedTasks.forEach { (date, tasksForDate) ->
                item {
                    Text(date, fontSize = 16.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 8.dp))
                }
                items(tasksForDate) { task ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clickable { viewModel.selectTask(task.id) },
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(task.title, fontSize = 14.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Checkbox(
                                checked = task.done,
                                onCheckedChange = { viewModel.toggleDone(task.id) }
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(onClick = { viewModel.removeTask(task.id) }) {
                                Text("Delete")
                            }
                        }
                    }
                }
            }
        }
    }
}
