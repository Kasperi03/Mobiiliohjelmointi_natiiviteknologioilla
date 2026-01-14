package com.example.viikkotehtava1.domain

import androidx.compose.runtime.mutableStateListOf
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class Task(
    val task: String = "",
    var id: Int = 0,
    val done: Boolean = false,
    val dueDay: String = "00.00.0000"
)
class taskList {
    val currentDate = SimpleDateFormat("dd.MM.yyyy",
        Locale.getDefault()).format(Date())
    val items = mutableStateListOf<Task>()
    fun addTask(taskName: String, dueDay: String, done: Boolean) {
        val newTask = Task(
            task = taskName,
            id = items.size + 1,
            dueDay = dueDay,
            done = done
        )
        items.add(newTask)
    }

    fun toggleDone(id: Int) {
        items.replaceAll { task ->
            if (task.id == id) task.copy(done = !task.done)
            else task
        }
    }

    fun filterByDone(done: Boolean): List<Task> {
        return items.filter { it.done == done }
    }

    fun sortByDueDate(): List<Task> {
        return items.sortedBy { it.dueDay }
    }
}