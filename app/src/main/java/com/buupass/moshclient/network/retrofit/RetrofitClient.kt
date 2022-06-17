package com.masjid.timetable.retrofit

import com.buupass.moshclient.network.retrofit.MasjidApi

import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {


    private const val BASE_URL = "https://fakestoreapi.com/"


    //instance of the marketplace API
    val instance: MasjidApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(MasjidApi::class.java)
    }
}