package com.example.pam_nvvm2_andini_copy.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pam_nvvm2_andini_copy.ui.screen.MahasiswaFormView
import com.example.pam_nvvm2_andini_copy.ui.screen.RencanaStudyView
import com.example.pam_nvvm2_andini_copy.ui.screen.SplashView
import com.example.pam_nvvm2_andini_copy.ui.screen.TampilView
import com.example.pam_nvvm2_andini_copy.ui.viewmodel.MahasiswaViewModel
import com.example.pam_nvvm2_andini_copy.ui.viewmodel.RencanaStudyViewModel

enum class Halaman{
    Splash,
    Mahasiswa,
    MataKuliah,
    Tampil
}

@Composable
fun PengelolaHalaman(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val mahasiswaUiState by mahasiswaViewModel.mahasiswaUiState.collectAsState()
    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = Modifier.padding()
    ) {
        composable(route = Halaman.Splash.name){
            SplashView(
                onMulaiButton = {
                    navController.navigate(Halaman.Mahasiswa.name)
                }
            )
        }
        composable(route = Halaman.Mahasiswa.name){
            MahasiswaFormView(
                onSubmitButtonClicked = {
                    mahasiswaViewModel.saveDataMahasiswa(it)
                    navController.navigate(Halaman.MataKuliah.name) },
                onBackButtonClicked = { navController.popBackStack()
                }
            )
        }
        composable(route = Halaman.MataKuliah.name){
            RencanaStudyView(
                mahasiswa = mahasiswaUiState,
                onSubmitButtonClicked = { krsViewModel.saveDataKRS(it)
                navController.navigate(Halaman.Tampil.name) },
                onBackButtonClicked = { navController.popBackStack()
                }
            )
        }
        composable(route = Halaman.Tampil.name){
            TampilView(
                mahasiswa = mahasiswaUiState,
                rencanaStudy = krsViewModel.krsStateUi.collectAsState().value,
                onBackToMainClicked = { navController.navigate(Halaman.Splash.name)
                }
            )
        }
    }
}