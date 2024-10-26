package com.example.primarynotesapp.data.dp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.primarynotesapp.data.dp.entity.NotesEntity

@Dao
interface NotesDao {
    @Insert
    suspend fun insert(text: NotesEntity)

    @Query("SELECT * FROM notes_table ORDER BY id DESC")
    fun getAllNotes(): LiveData<List<NotesEntity>>

    @Query("SELECT * FROM notes_table ORDER BY id DESC LIMIT 1")
    fun getLastText(): LiveData<NotesEntity>
}