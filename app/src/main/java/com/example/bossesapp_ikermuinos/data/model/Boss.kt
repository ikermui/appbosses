package com.example.bossesapp_ikermuinos.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "boss_table")
data class Boss(
    @PrimaryKey(autoGenerate = false)
    val nombre: String,
    val juego: String,
    val diff: Int
)
