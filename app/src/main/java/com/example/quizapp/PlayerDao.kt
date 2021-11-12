package com.example.quizapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PlayerDao {
    @Insert
    fun insert(item: Player)

    @Delete
    fun delete(item:Player)

    @Query("SELECT * FROM item_table ORDER BY score DESC LIMIT 5")
    fun getAll() : List<Player>

    @Query("SELECT * FROM item_table WHERE score LIKE :score")
    fun findByScore(score: Int) : List<Player>
}



