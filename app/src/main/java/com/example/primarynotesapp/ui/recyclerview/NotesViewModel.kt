package com.example.primarynotesapp.ui.recyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.primarynotesapp.data.dp.entity.NotesEntity
import com.example.primarynotesapp.data.repository.NotesRepository
import kotlinx.coroutines.launch

class NotesViewModel(private val repository: NotesRepository) : ViewModel() {

    private val _lastText = MutableLiveData<NotesEntity>()
    val lastText: LiveData<NotesEntity> = _lastText

    val textList: LiveData<List<NotesEntity>> = repository.getAllNotes()

    fun insertText(text: String) {
        viewModelScope.launch {
            val notesEntity = createTextEntity(text)
            kotlin.runCatching {
                repository.insertText(notesEntity)
            }.onSuccess {
                _lastText.value = notesEntity
            }.onFailure {
            }
        }
    }

    private fun createTextEntity(text: String): NotesEntity {
        return NotesEntity(text = text)
    }
}