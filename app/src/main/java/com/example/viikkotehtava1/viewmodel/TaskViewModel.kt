package com.example.viikkotehtava1.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.viikkotehtava1.domain.Task
import java.time.LocalDate
import kotlin.collections.plus

class TaskViewModel : ViewModel() {
    var tasks by mutableStateOf(listOf<Task>())
        private set

    init {
        addTask(
            "Buy milk", "", 1,
            dueDay = LocalDate.of(2026, 1, 13),
            done = false
        )
        addTask("Call mom", "", 2,
            dueDay = LocalDate.of(2025, 3, 10),
            done = true)
        addTask(
            "Do homework", "", 3,
            dueDay = LocalDate.of(2024, 7, 27),
            done = false
        )
        addTask(
            "Read a book", "", 4,
            dueDay = LocalDate.of(2025, 12, 31),
            done = false
        )
        addTask(
            "Clean room", "", 5,
            dueDay = LocalDate.of(2025, 10, 2),
            done = true
        )

    }
    fun addTask(taskName: String, description: String,
                priority: Int, dueDay: LocalDate, done: Boolean) {
        val newTask = Task(
            title = taskName,
            id = tasks.size + 1,
            description = description,
            priority = priority,
            dueDay = dueDay,
            done = done,
        )
        tasks = tasks + newTask
    }

    fun toggleDone(id: Int) {
        tasks = tasks.map { task ->
            if (task.id == id) task.copy(done = !task.done)
            else task
        }
    }

    fun filterByDone(done: Boolean) {
        tasks = tasks.filter { it.done == done }
    }

    fun sortByDueDate() {
        tasks = tasks.sortedBy { it.dueDay }
    }

    fun removeTask(id: Int){
        tasks = tasks.filter { it.id != id }
    }
}