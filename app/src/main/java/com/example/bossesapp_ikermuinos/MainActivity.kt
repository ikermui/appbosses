package com.example.bossesapp_ikermuinos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.bossesapp_ikermuinos.data.database.BossDatabase
import com.example.bossesapp_ikermuinos.data.model.Boss
import com.example.bossesapp_ikermuinos.navigate.NavManager
import com.example.bossesapp_ikermuinos.ui.theme.BossesApp_IkerMuinosTheme
import com.example.bossesapp_ikermuinos.viewmodel.BossViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val database =
                Room.databaseBuilder(this, BossDatabase::class.java, "boss_table")
                    .build()
            val dao = database.dao
            val viewModel by viewModels<BossViewModel>(
                factoryProducer = {
                    object : ViewModelProvider.Factory {
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            return BossViewModel(dao) as T
                        }
                    }
                }
            )
            NavManager(viewModel)
        }
    }
}