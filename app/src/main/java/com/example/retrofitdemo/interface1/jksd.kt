package com.example.retrofitdemo.interface1

import android.annotation.SuppressLint
import com.example.retrofitdemo.Result
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val url = "https://quotable.io/quotes?page=1"
object RetrofitHelper{

    val baseUrl = "https://quotable.io/"
    val baseUrl2 = "https://jsonplaceholder.typicode.com/"


    @SuppressLint("SuspiciousIndentation")
    fun getInstance() : Retrofit{
     var instance = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
        return instance
    }

    @SuppressLint("SuspiciousIndentation")
    fun putInstance() : Retrofit{
     var instance = Retrofit.Builder().baseUrl(baseUrl2).addConverterFactory(GsonConverterFactory.create()).build()
        return instance
    }

}