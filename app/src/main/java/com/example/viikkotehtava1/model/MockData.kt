package com.example.viikkotehtava1.model

import java.time.LocalDate

val mockTask = listOf(
    Task("Buy milk", 2, "", 1, false,
    LocalDate.of(2026, 1, 13),
    ),
    Task("Call mom", 2, "", 2, true,
    LocalDate.of(2025, 3, 10),
    ),
    Task("Do homework", 3, "", 3, false,
    LocalDate.of(2024, 7, 27),
    ),
    Task("Read a book", 4, "", 4, false,
        LocalDate.of(2025, 3, 17),
    ),
    Task("Play with friends", 5, "", 5, false,
        LocalDate.of(2026, 1, 29),
    ),
)