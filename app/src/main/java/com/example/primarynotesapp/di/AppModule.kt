package com.example.primarynotesapp.di

import androidx.room.Room
import com.example.primarynotesapp.data.dp.AppDatabase
import com.example.primarynotesapp.data.repository.NotesRepository
import com.example.primarynotesapp.data.repository.NotesRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "my_task_database.db")
            .build()
    }

    single { get<AppDatabase>().textDao() }

    single<NotesRepository> { NotesRepositoryImpl(get()) }
}
