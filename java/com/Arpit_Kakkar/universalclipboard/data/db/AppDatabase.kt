package com.Arpit_Kakkar.universalclipboard.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.Arpit_Kakkar.universalclipboard.data.dao.ClipboardDao
import com.Arpit_Kakkar.universalclipboard.data.entity.ClipboardEntity

@Database(
    entities = [ClipboardEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun clipboardDao(): ClipboardDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "clipboard_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
