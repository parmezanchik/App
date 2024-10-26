package com.example.primarynotesapp.data.repository

import androidx.lifecycle.LiveData
import com.example.primarynotesapp.data.dp.dao.NotesDao
import com.example.primarynotesapp.data.dp.entity.NotesEntity

class NotesRepositoryImpl(
    private val textDao: NotesDao
) : NotesRepository {
    override suspend fun insertText(text: NotesEntity) {
        val entity = NotesEntity(text = text.text)
        textDao.insert(entity)
    }

    override fun getAllNotes(): LiveData<List<NotesEntity>> {
        return textDao.getAllNotes()
    }
}