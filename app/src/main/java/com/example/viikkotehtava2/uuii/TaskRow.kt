package com.example.viikkotehtava2.uuii

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.viikkotehtava2.model.Task

@Composable
fun TaskRow(
    task: Task,
    onToggle: () -> Unit,
    onDelete: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Checkbox(
                checked = task.done,
                onCheckedChange = { onToggle() }
            )
            Spacer(Modifier.width(8.dp))
            Column {
                Text(task.title)
                Text(
                    task.dueDate,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

        TextButton(onClick = onDelete) {
            Text("Poista")
        }
    }
}
