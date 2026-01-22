package com.example.viikkotehtava2.uuii

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viikkotehtava2.model.Task
import com.example.viikkotehtava2.viewmodel.TaskViewModel

@Composable
fun HomeScreen(
    taskViewModel: TaskViewModel = viewModel()
) {
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Tehtävälista",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { taskViewModel.filterByDone(false) }) {
                Text("Kesken")
            }
            Button(onClick = { taskViewModel.filterByDone(true) }) {
                Text("Valmiit")
            }
            Button(onClick = { taskViewModel.showAllTasks() }) {
                Text("Kaikki")
            }

        }

        Spacer(Modifier.height(8.dp))

        Row {
            Button(onClick = { taskViewModel.sortByDueDate() }) {
                Text("Järjestä päivämäärän mukaan")
            }
        }


        Spacer(Modifier.height(16.dp))

        Row {
            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Uusi tehtävä") }
            )
            Spacer(Modifier.width(8.dp))
            Button(onClick = {
                if (text.isNotBlank()) {
                    taskViewModel.addTask(
                        Task(
                            id = taskViewModel.tasks.size + 1,
                            title = text,
                            done = false,
                            dueDate = java.time.LocalDate.now().toString()
                        )
                    )
                    text = ""
                }
            }) {
                Text("Lisää")
            }
        }

        Spacer(Modifier.height(16.dp))

        Card {
            LazyColumn(modifier = Modifier.padding(8.dp)) {
                items(taskViewModel.tasks) { task ->
                    TaskRow(
                        task = task,
                        onToggle = { taskViewModel.toggleDone(task.id) },
                        onDelete = { taskViewModel.removeTask(task.id) }
                    )
                }
            }
        }
    }
}
