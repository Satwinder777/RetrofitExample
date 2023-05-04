package com.example.retrofitdemo.interface1

import com.example.retrofitdemo.dataclass.Data
import com.example.retrofitdemo.dataclass.DataItem
import com.example.retrofitdemo.dataclass.QuoteList
import retrofit2.Call
import retrofit2.http.*

const val  a = "https://quotable.io/search/authors?query=john quincy adams"

interface QuoteApi {
    @GET("/quotes")

    fun getQuote() : Call<QuoteList>





    @GET("/posts")
    fun getData() : Call<Data>

    @GET("/search/authors")
    fun searchData(@Query("query") query: String): Call<QuoteList>

    @POST("/posts")
    fun postData(@Body data: DataItem) : Call<DataItem>

    @DELETE("/posts/{id}")
    fun deleteData(@Path("id") id:Int ):Call<DataItem>

    @PUT("posts/{id}")
    fun updateData(@Path("id") id:Int ,@Body data: DataItem):Call<DataItem>

    @PATCH("posts/{id}")
    fun patchData(@Path("id") id:Int ,@Body data: DataItem):Call<DataItem>

}