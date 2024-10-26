package com.example.primarynotesapp.di

import com.example.primarynotesapp.ui.recyclerview.NotesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModel = module {
    viewModel { NotesViewModel(get()) }
}