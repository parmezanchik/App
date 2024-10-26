package com.example.primarynotesapp.data.dp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.primarynotesapp.data.dp.dao.NotesDao
import com.example.primarynotesapp.data.dp.entity.NotesEntity

@Database(entities = [NotesEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun textDao(): NotesDao
}
