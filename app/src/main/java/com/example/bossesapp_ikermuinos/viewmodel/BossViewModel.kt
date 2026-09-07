package com.example.bossesapp_ikermuinos.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Dao
import com.example.bossesapp_ikermuinos.data.dao.BossDao
import com.example.bossesapp_ikermuinos.data.model.Boss
import com.example.bossesapp_ikermuinos.data.state.BossState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class BossViewModel(
    private val dao: BossDao
) : ViewModel(){
    var state by mutableStateOf(BossState())
        private set

    init {
        viewModelScope.launch {
            dao.getAllBosses().collectLatest{}
        }
    }
}