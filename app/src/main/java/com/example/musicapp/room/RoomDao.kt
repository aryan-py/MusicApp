package com.example.musicapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.musicapp.Data


@Dao
interface RoomDao {

    @Insert
    suspend fun insertData(data:List<Data>)

    @Query( value =  "SELECT * FROM data")
    suspend fun getData():List<Data>
}