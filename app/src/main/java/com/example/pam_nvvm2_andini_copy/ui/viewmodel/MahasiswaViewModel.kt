package com.example.pam_nvvm2_andini_copy.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pam_nvvm2_andini_copy.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel(){

    //Request atau event
    private val _mahasiswaStateUI =
        MutableStateFlow(Mahasiswa())


}