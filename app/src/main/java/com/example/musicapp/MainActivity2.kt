package com.example.musicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicapp.room.DataDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity2 : AppCompatActivity() {
    lateinit var myRecyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        myRecyclerView =findViewById(R.id.recyclerView)
        val retrofitBuilder= Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData =retrofitBuilder.getData("eminem")


        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call : Call<MyData?>, response: Response<MyData?>) {

                // if the API call is a success
                val dataList =response.body()?.data!!


                myAdapter= MyAdapter(this@MainActivity2,dataList)
                myRecyclerView.adapter= myAdapter
                myRecyclerView.layoutManager= LinearLayoutManager(this@MainActivity2)


            }

            override fun onFailure(call : Call<MyData?>, t: Throwable){


            }
        }
        )

    }
}