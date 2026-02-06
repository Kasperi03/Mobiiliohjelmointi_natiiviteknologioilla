package com.example.viikkotehtava1.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.viikkotehtava1.viewmodel.TaskViewModel
import androidx.compose.ui.text.TextStyle
import androidx.lifecycle.viewmodel.compose.viewModel
import java.time.LocalDate
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.viikkotehtava1.model.Task
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: TaskViewModel,
    onNavigateCalendar: () -> Unit
) {
    val tasks by viewModel.tasks.collectAsState()
    val selectedTask by viewModel.selectedTask.collectAsState()

    if (selectedTask != null) {
        DetailDialog(
            task = selectedTask!!,
            onClose = { viewModel.clearTask() },
            onUpdate = { viewModel.updateTask(it) }
        )
    }

    Column {
        TopAppBar(
            title = { Text("Task List") },
            actions = {
                IconButton(onClick = onNavigateCalendar) {
                    Icon(
                        imageVector = Icons.Default.CalendarMonth,
                        contentDescription = "Go to calendar"
                    )
                }
            }
        )

    Column(modifier = Modifier.padding(16.dp)) {
        Row {
            Button(onClick = { viewModel.filterByDone(done = true) }) {
                Text("Show Done")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { viewModel.filterByDone(done = false) }) {
                Text("Show not Done")
            }
        }
        Row {
            Button(onClick = { viewModel.sortByDueDate() }) {
                Text("Sort by due day")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { viewModel.showAll()}) {
                Text("Show All")
            }
        }
    }
    LazyColumn(modifier = Modifier.weight(1f)) {
        items(tasks) { task ->
            Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp).clickable { viewModel.selectTask(task.id) },
                colors = CardDefaults.cardColors(containerColor = Color.White),
                ) {
                Row( modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("${task.title} – ${task.dueDay}", fontSize = 14.sp)
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
    Column(modifier = Modifier.padding(16.dp)) {

        Row(modifier = Modifier.padding(16.dp)) {
            var task by remember { mutableStateOf("") }

            OutlinedTextField(
                value = task,
                onValueChange = { task = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Write task") },
                textStyle = TextStyle(color = Color.Black)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { viewModel.addTask(Task(task,0,
                "",0,false, LocalDate.now()))}){
                Text("Add task")
            }
        }
    }
}
}
