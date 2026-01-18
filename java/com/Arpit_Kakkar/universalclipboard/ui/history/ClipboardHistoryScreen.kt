package com.Arpit_Kakkar.universalclipboard.ui.history

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ClipboardHistoryScreen(
    items: List<ClipboardItemUi>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items) { item ->
            ClipboardItemRow(item)
        }
    }
}

@Composable
private fun ClipboardItemRow(item: ClipboardItemUi) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                // copy action will be implemented later
            }
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = item.content,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.timestamp,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
