package com.example.viikkotehtava1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.viikkotehtava1.domain.taskList
import androidx.compose.ui.text.TextStyle
@Composable
fun HomeScreen() {

    val taskList = remember {
        taskList().apply {
            addTask("Buy milk", dueDay = "10.01.2026", done = false)
            addTask("Call mom", dueDay = "31.10.2024", done = true)
            addTask("Do homework", dueDay = "21.12.2025", done = false)
            addTask("Read a book", dueDay = "20.07.2025", done = false)
            addTask("Clean room", dueDay = "01.03.2025", done = true)
        }
    }

    val displayedTasks = remember { mutableStateOf(taskList.items.toList()) }

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = "Task List",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row {
            Button(onClick = { displayedTasks.value = taskList.filterByDone(true) }) {
                Text("Show Done")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { displayedTasks.value = taskList.items.toList() }) {
                Text("Show All")
            }
        }
        Button(onClick = { displayedTasks.value = taskList.sortByDueDate() }) {
            Text("Sort by due day")
        }

        LazyColumn {
            items(displayedTasks.value) { t ->
                Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(modifier = Modifier
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "${t.task} – ${t.dueDay}")
                        Spacer(modifier = Modifier.width(8.dp))
                        if (t.done) {
                            Text(" Task done")
                        } else {
                            Button(onClick = {
                                taskList.toggleDone(t.id)
                                displayedTasks.value = displayedTasks.value.map {
                                    if (it.id == t.id) it.copy(done = !it.done) else it
                                }
                            }) {
                                Text("Done")
                            }
                        }
                    }
                }
            }
        }
        Row (modifier = Modifier.padding(16.dp)) {

            val newTask = remember { mutableStateOf("") }
            OutlinedTextField(
                value = newTask.value,
                onValueChange = { newValue -> newTask.value = newValue },
                        modifier = Modifier
                        .weight(1f),
                placeholder = { Text("Write task") },
                textStyle = TextStyle(color = Color.Black)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                taskList.addTask(newTask.value, dueDay = taskList.currentDate, done = false)
                displayedTasks.value = taskList.items.toList()
            }) {
                Text("Add Task")
            }
        }
    }
}
