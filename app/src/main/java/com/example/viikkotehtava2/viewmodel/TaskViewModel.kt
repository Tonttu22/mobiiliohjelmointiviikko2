package com.example.viikkotehtava2.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.viikkotehtava2.model.Task

class TaskViewModel : ViewModel() {

    private var allTasks = listOf<Task>()
    var tasks by mutableStateOf(listOf<Task>())
        private set

    private var sortAscending = true

    init {
        allTasks = listOf(
            Task(1, "Osta maitoa", false, "2025-10-31"),
            Task(2, "Tee viikkotehtävä", true, "2025-11-01"),
            Task(3, "Käy lenkillä", false, "2025-10-30")
        )
        tasks = allTasks
    }

    fun addTask(task: Task) {
        allTasks = allTasks + task
        tasks = allTasks
    }

    fun toggleDone(id: Int) {
        allTasks = allTasks.map {
            if (it.id == id) it.copy(done = !it.done) else it
        }
        tasks = allTasks
    }

    fun removeTask(id: Int) {
        allTasks = allTasks.filterNot { it.id == id }
        tasks = allTasks
    }

    fun filterByDone(done: Boolean) {
        tasks = allTasks.filter { it.done == done }
    }

    fun showAllTasks() {
        tasks = allTasks
    }

    fun sortByDueDate() {
        tasks = if (sortAscending) {
            tasks.sortedBy { it.dueDate }
        } else {
            tasks.sortedByDescending { it.dueDate }
        }
        sortAscending = !sortAscending
    }
}

