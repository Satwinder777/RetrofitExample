package com.example.retrofitdemo.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.R
import com.example.retrofitdemo.Result
import com.example.retrofitdemo.adapter.SearchAdapter
import com.example.retrofitdemo.adapter.SearchAdapter2
import com.example.retrofitdemo.dataclass.QuoteList
import com.example.retrofitdemo.interface1.QuoteApi
import com.example.retrofitdemo.interface1.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        lateinit var list :MutableList<Result>
        var searchEdit  = findViewById<EditText>(R.id.search_edit)
        var searchBtn  = findViewById<Button>(R.id.searchbtn)
        var recyclerView = findViewById<RecyclerView>(R.id.search_recycler)
        list = mutableListOf()
        val adapter = SearchAdapter2(this@SearchActivity,list)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter

        searchBtn.setOnClickListener {
            val quotesApi = RetrofitHelper.getInstance().create(QuoteApi::class.java)


            var a  = searchEdit.text.toString()
            val callForSearchView = quotesApi.searchData(a)




//            val intent = Intent(this,newActivity::class.java)
//            startActivity(intent)


            callForSearchView.enqueue(object: Callback<QuoteList> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(call: Call<QuoteList>, response: Response<QuoteList>) {
                    list.clear()
                    if (response.isSuccessful){
                        var finalData = response.body()!!

                        Log.e("Databs", "onResponse: $finalData", )
                        for(mydata1 in 0..finalData.results.size-1) {


                            var finalD = finalData.results[mydata1]
                            list.add(finalD)
                        }


                    }
                    else{
                        Toast.makeText(this@SearchActivity, "not executes", Toast.LENGTH_SHORT).show()
                        Log.e("Databs", "onResponse: ${response.body()}", )
                    }

                    recyclerView.adapter = adapter
                    adapter.notifyDataSetChanged()

                }

                override fun onFailure(call: Call<QuoteList>, t: Throwable) {
                    Toast.makeText(this@SearchActivity, "error", Toast.LENGTH_SHORT).show()
                    Log.e("Databs", "onResponse: ${t.message}", )


                }

            })

        }

    }
}