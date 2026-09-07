package com.example.bossesapp_ikermuinos.navigate

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bossesapp_ikermuinos.viewmodel.BossViewModel
import com.example.bossesapp_ikermuinos.views.buscador.BuscadorScreen
import com.example.bossesapp_ikermuinos.views.gameinfo.BloodborneScreen
import com.example.bossesapp_ikermuinos.views.gameinfo.DarkSouls2Screen
import com.example.bossesapp_ikermuinos.views.gameinfo.DarkSouls3Screen
import com.example.bossesapp_ikermuinos.views.gameinfo.DarkSoulsScreen
import com.example.bossesapp_ikermuinos.views.gameinfo.DsScreen
import com.example.bossesapp_ikermuinos.views.gameinfo.EldenRingScreen
import com.example.bossesapp_ikermuinos.views.mainView

@Composable
fun NavManager(viewModel: BossViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            mainView(navController)
        }
        composable("ds1"){
            DarkSoulsScreen(navController)
        }
        composable("ds2"){
            DarkSouls2Screen(navController)
        }
        composable("ds3"){
            DarkSouls3Screen(navController)
        }
        composable("bloodborne"){
            BloodborneScreen(navController)
        }
        composable("er") {
            EldenRingScreen(navController)
        }
        composable("ds") {
            DsScreen(navController)
        }
        composable("buscador"){
            BuscadorScreen(viewModel)
        }
    }
}