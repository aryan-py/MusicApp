package com.example.musicapp


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {


    @Headers("X-RapidAPI-Key': '059d3726a0mshf4e3962a36a063bp1dcda5jsnf4b21e5627bf",
            "    X-RapidAPI-Host': 'deezerdevs-deezer.p.rapidapi.com")
    @GET("Search")
    fun getData(@Query("q") query: String) : Call<MyData>

}