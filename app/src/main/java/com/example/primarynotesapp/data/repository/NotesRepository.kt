package com.example.primarynotesapp.data.repository

import androidx.lifecycle.LiveData
import com.example.primarynotesapp.data.dp.entity.NotesEntity

interface NotesRepository {
    suspend fun insertText(text: NotesEntity)
    fun getAllNotes(): LiveData<List<NotesEntity>>
}