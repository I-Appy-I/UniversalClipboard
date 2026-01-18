package com.Arpit_Kakkar.universalclipboard.clipboard

import android.content.ClipboardManager
import android.content.Context
import com.Arpit_Kakkar.universalclipboard.data.db.AppDatabase
import com.Arpit_Kakkar.universalclipboard.data.entity.ClipboardEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClipboardWatcher(
    context: Context
) {

    private val clipboardManager =
        context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

    private val dao =
        AppDatabase.getInstance(context).clipboardDao()

    fun start() {
        clipboardManager.addPrimaryClipChangedListener {
            val clip = clipboardManager.primaryClip
            val text = clip?.getItemAt(0)?.coerceToText(null)?.toString()

            if (!text.isNullOrBlank()) {
                CoroutineScope(Dispatchers.IO).launch {
                    dao.insert(
                        ClipboardEntity(
                            content = text,
                            timestamp = System.currentTimeMillis()
                        )
                    )
                }
            }
        }
    }
}
