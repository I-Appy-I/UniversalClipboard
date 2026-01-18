package com.Arpit_Kakkar.universalclipboard.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.Arpit_Kakkar.universalclipboard.data.entity.ClipboardEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClipboardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ClipboardEntity)

    @Query("SELECT * FROM clipboard_items ORDER BY timestamp DESC")
    fun getAllClipboardItems(): Flow<List<ClipboardEntity>>
}
