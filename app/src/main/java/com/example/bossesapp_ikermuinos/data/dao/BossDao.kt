package com.example.bossesapp_ikermuinos.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bossesapp_ikermuinos.data.model.Boss
import kotlinx.coroutines.flow.Flow


@Dao
interface BossDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBoss(boss: Boss)

    @Query("SELECT * FROM boss_table")
    fun getAllBosses(): Flow<List<Boss>>

    @Delete
    suspend fun deleteBoss(boss: Boss)
}