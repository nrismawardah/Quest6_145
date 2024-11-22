package com.example.quest6_145.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import com.example.quest6_145.ui.model.Mahasiswa
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel()
{
    private val _mahasiswaUiState = MutableStateFlow(Mahasiswa())
    val mahasiswaUiState: StateFlow<Mahasiswa> = _mahasiswaUiState.asStateFlow()

    fun saveDataMahasiswa(mahasiswa: Mahasiswa) {
        _mahasiswaUiState.update { currentState ->
            currentState.copy(
                nim = mahasiswa.nim,
                nama = mahasiswa.nama,
                email = mahasiswa.email
            )
        }
    }
}