package com.example.bossesapp_ikermuinos.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bossesapp_ikermuinos.data.dao.BossDao
import com.example.bossesapp_ikermuinos.data.model.Boss

@Database(entities = [Boss::class], version = 1)
abstract class BossDatabase : RoomDatabase() {
    abstract val dao : BossDao;
}