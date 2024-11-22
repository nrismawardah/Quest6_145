package com.example.quest6_145.navigasi

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
import com.example.quest6_145.ui.model.Mahasiswa
import com.example.quest6_145.ui.model.RencanaStudi
import com.example.quest6_145.ui.view.screen.MahasiswaFormView
import com.example.quest6_145.ui.view.screen.RencanaStudyView
import com.example.quest6_145.ui.view.screen.SplashView
import com.example.quest6_145.ui.view.viewmodel.MahasiswaViewModel
import com.example.quest6_145.ui.view.viewmodel.RencanaStudyViewModel

enum class Halaman {
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil,
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    val mahasiswaUiState by mahasiswaViewModel.mahasiswaUiState.collectAsState()
    val krsStateUi by krsViewModel.krsStateUi.collectAsState()

    NavHost(
        modifier = modifier.padding(),
        navController = navController,
        startDestination = Halaman.Splash.name
    ){
        composable(
            route = Halaman.Splash.name
        ){
            SplashView(onMulaiButton = { navController.navigate(Halaman.Mahasiswa.name) })
        }
        composable(route = Halaman.Mahasiswa.name) {
            MahasiswaFormView(
                onSubmitButtonClicked = { listDataMhs ->
                    mahasiswaViewModel.saveDataMahasiswa(Mahasiswa(
                        nim = listDataMhs[0],
                        nama = listDataMhs[1],
                        email = listDataMhs[2])
                    )
                    navController.navigate(Halaman.Matakuliah.name)
                },
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Halaman.Matakuliah.name) {
            RencanaStudyView(
                mahasiswa = mahasiswaUiState,
                onSubmitButtonClicked = { listData ->
                    krsViewModel.saveDataKRS(RencanaStudi(namaMK = listData[0], kelas = listData[1]))
                    navController.navigate(Halaman.Tampil.name)
                },
                onBackButtonClicked = { navController.popBackStack() }
            )
        }
    }
}