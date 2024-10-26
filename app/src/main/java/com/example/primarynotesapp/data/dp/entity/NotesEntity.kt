package com.example.primarynotesapp.data.dp.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class NotesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val text: String?
)
