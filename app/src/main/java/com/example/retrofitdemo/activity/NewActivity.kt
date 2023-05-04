package com.example.retrofitdemo.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.*
import com.example.retrofitdemo.adapter.CustomAdapter2
import com.example.retrofitdemo.dataclass.Data
import com.example.retrofitdemo.dataclass.DataItem
import com.example.retrofitdemo.interface1.QuoteApi
import com.example.retrofitdemo.interface1.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class newActivity : AppCompatActivity() {
    private lateinit var recyc :RecyclerView
    lateinit var list :MutableList<DataItem>
    var adapter: CustomAdapter2?=null
    val id  = 3
    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

         recyc = findViewById(R.id.recyclerid)
        list = mutableListOf()
//        var adapter = CustomAdapter2(this,list)
//        recyc.layoutManager = LinearLayoutManager(this)
//        recyc.adapter = adapter
        var postData = findViewById<Button>(R.id.postData)
        var PatchData = findViewById<Button>(R.id.updateData)


        val quoteApi2 = RetrofitHelper.putInstance().create(QuoteApi::class.java)

        val call2 : Call<DataItem> = quoteApi2.postData(DataItem("the quick brownfox ",101,"jumps over the lazt dog",101))
        val call3 : Call<Data> = quoteApi2.getData()
        val call4 :Call<DataItem> = quoteApi2.patchData(id,
            DataItem("the quick brownfox ",101,"jumps over the lazt dog",101)
        )

        postData.setOnClickListener {
            call2.enqueue(object: Callback<DataItem?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<DataItem?>, response: Response<DataItem?>) {

//                Log.e("detail", "onResponse: call2 " )
//                Log.e("detail", "onResponse: "+response.body().toString() )
//                list.clear()
                var newresponce = response.body()!!
                var newData = newresponce
                list.add(newData)
                recyc.adapter = adapter
                adapter?.notifyItemInserted(101)
                Log.e("code", "code :${response.code()}",)


//                list.removeAt(id)
//                list.add(newData)
                adapter?.notifyDataSetChanged()
//                call3.enqueue(object: Callback<Data?> {
//                    override fun onResponse(call: Call<Data?>, response: Response<Data?>) {
////                Log.e("detail", "onResponse: " + response.body().toString())
//
//
//                        var newresponce = response.body()!!
//                        for (myData in 0..newresponce.size-1) {
//                            var newData = newresponce[myData]
//                            list.add(newData)
////                    Log.e("detail", "onResponse: "+newData )
//
//
//                            adapter = CustomAdapter2(list,this@newActivity)
//                            recyc.adapter = adapter
//                            adapter?.notifyDataSetChanged()
//
//                        }
//                        Log.e("code", "code :${response.code()}", )
//
//                    }
//                    override fun onFailure(call: Call<Data?>, t: Throwable) {
//                        Toast.makeText(this@newActivity, "the call3 got an error", Toast.LENGTH_SHORT).show()
//                    }
//
//                })
            }

            override fun onFailure(call: Call<DataItem?>, t: Throwable) {
                Toast.makeText(this@newActivity ,"request failed   call2 ", Toast.LENGTH_SHORT).show()

            }
        })



        }







        call3.enqueue(object: Callback<Data?> {
            override fun onResponse(call: Call<Data?>, response: Response<Data?>) {
//                Log.e("detail", "onResponse: " + response.body().toString())


                var newresponce = response.body()!!
                for (myData in 0..newresponce.size-1) {
                    var newData = newresponce[myData]
                    list.add(newData)
//                    Log.e("detail", "onResponse: "+newData )


                    adapter = CustomAdapter2(list,this@newActivity)
                    recyc.adapter = adapter
                    adapter?.notifyDataSetChanged()

                }
                Log.e("code", "code :${response.code()}", )

            }
            override fun onFailure(call: Call<Data?>, t: Throwable) {
                Toast.makeText(this@newActivity, "the call3 got an error", Toast.LENGTH_SHORT).show()
            }

        })
        PatchData.setOnClickListener {

            call4.enqueue(object :Callback<DataItem>{
            override fun onResponse(call: Call<DataItem>, response: Response<DataItem>) {

               list.removeAt(id)
                list.add(id,response.body()!!)


                var newresponce = response.body()!!
                var newData =  newresponce
                list.add(newData)
                recyc.adapter = adapter
                adapter?.notifyDataSetChanged()

                Log.e("code", "code :${response.code()}", )

                Log.e("updateData", "onResponse: fwehsfhaeihwivhwifhsiuh   ${response.body()}" )
            }

            override fun onFailure(call: Call<DataItem>, t: Throwable) {
                Toast.makeText(this@newActivity, "call4 does not works", Toast.LENGTH_SHORT).show()
            }

        }) }
        val call5: Call<DataItem> = quoteApi2.deleteData(id-2)
        val nonebtn =  findViewById<Button>(R.id.none)
        nonebtn.setOnClickListener {
            call5.enqueue(object : Callback<DataItem> {
                override fun onResponse(call: Call<DataItem>, response: Response<DataItem>) {
                    list.removeAt(id-2)
                    recyc.adapter = adapter
                    adapter?.notifyItemRemoved(id-2)
                    Log.e("code", "code :${response.code()}", )
                }

                override fun onFailure(call: Call<DataItem>, t: Throwable) {
                    Toast.makeText(this@newActivity, "this call5 does not work", Toast.LENGTH_SHORT).show()
                }

            })

        }


    }
}