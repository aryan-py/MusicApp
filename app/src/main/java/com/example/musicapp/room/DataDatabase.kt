package com.example.musicapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.musicapp.Data


@Database(entities = [Data::class], version = 1 )
abstract class DataDatabase : RoomDatabase() {

    abstract fun dataDao() : RoomDao

    companion object{
        private var  INSTANCE : DataDatabase? =null

        fun getDatabase(context :Context) {

            if(INSTANCE==null){
                INSTANCE = Room.databaseBuilder(context,
                    DataDatabase:: class.java,
                     "dataDB"
                ).build()
            }
        }
    }

}