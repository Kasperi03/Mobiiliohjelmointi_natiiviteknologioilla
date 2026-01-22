package com.example.viikkotehtava1.domain

import java.time.LocalDate
data class Task(
    val title: String = "",
    var id: Int = 0,
    val description: String = "",
    var priority: Int = 0,
    val done: Boolean = false,
    val dueDay: LocalDate)