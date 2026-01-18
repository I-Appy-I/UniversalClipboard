package com.Arpit_Kakkar.universalclipboard
import com.Arpit_Kakkar.universalclipboard.clipboard.ClipboardWatcher
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.Arpit_Kakkar.universalclipboard.ui.history.ClipboardHistoryScreen
import com.Arpit_Kakkar.universalclipboard.ui.history.ClipboardItemUi
import com.Arpit_Kakkar.universalclipboard.ui.theme.UniversalClipboardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UniversalClipboardTheme {

                val mockItems = listOf(
                    ClipboardItemUi(
                        id = "1",
                        content = "Hello from clipboard",
                        timestamp = "Just now"
                    ),
                    ClipboardItemUi(
                        id = "2",
                        content = "Another copied text",
                        timestamp = "2 minutes ago"
                    ),
                    ClipboardItemUi(
                        id = "3",
                        content = "Universal Clipboard Sync",
                        timestamp = "Yesterday"
                    )
                )

                ClipboardHistoryScreen(items = mockItems)
            }
        }

        val clipboardWatcher = ClipboardWatcher(this)
        clipboardWatcher.start()

    }
}
