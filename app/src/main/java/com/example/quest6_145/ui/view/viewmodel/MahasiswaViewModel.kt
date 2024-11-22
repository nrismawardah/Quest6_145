package com.example.quest6_145.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import com.example.quest6_145.ui.model.Mahasiswa
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MahasiswaViewModel : ViewModel()
{
    private val _mahasiswaUiState = MutableStateFlow(Mahasiswa())
    val mahasiswaUiState: StateFlow<Mahasiswa> = _mahasiswaUiState.asStateFlow()
}