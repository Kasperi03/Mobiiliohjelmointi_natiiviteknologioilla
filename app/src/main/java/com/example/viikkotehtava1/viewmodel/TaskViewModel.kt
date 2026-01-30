package com.example.viikkotehtava1.viewmodel

import androidx.lifecycle.ViewModel
import com.example.viikkotehtava1.model.Task
import com.example.viikkotehtava1.model.mockTask
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.collections.plus



class TaskViewModel : ViewModel() {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    private val _selectedTask = MutableStateFlow<Task?>(null)
    val selectedTask: StateFlow<Task?> = _selectedTask

    private var allTasks: List<Task> = mockTask

    fun addTask(newTask: Task){
        allTasks = allTasks + newTask
        _tasks.value = allTasks
    }

    fun toggleDone(id: Int) {
        allTasks = allTasks.map { task ->
            if (task.id == id) task.copy(done = !task.done)
            else task
        }
        _tasks.value = allTasks
    }

    fun filterByDone(done: Boolean) {
        _tasks.value = allTasks.filter { it.done == done }
    }

    fun showAll(){
        _tasks.value = allTasks
    }

    fun sortByDueDate() {
        _tasks.value = allTasks.sortedBy { it.dueDay }
    }

    fun removeTask(id: Int){
        allTasks = allTasks.filter { it.id != id }
        _tasks.value = allTasks
    }

    fun selectTask(id: Int){
        _selectedTask.value = allTasks.find { it.id == id }
    }

    fun clearTask(){
        _selectedTask.value = null
    }

    fun updateTask(updated: Task) {
        allTasks = allTasks.map {
            if (it.id == updated.id) updated else it
        }
        _tasks.value = allTasks
        _selectedTask.value = null
    }
}