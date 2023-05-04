package com.example.retrofitdemo.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.*
import com.example.retrofitdemo.adapter.CustomAdapter
import com.example.retrofitdemo.dataclass.QuoteList
import com.example.retrofitdemo.interface1.QuoteApi
import com.example.retrofitdemo.interface1.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CustomAdapter
//    var QuotedataList = arrayListOf<Result>()
    private lateinit var progressBar:ProgressBar

    lateinit var list :MutableList<Result>

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = mutableListOf()
        recyclerView = findViewById(R.id.recyclerview)
//        QuotedataList = arrayListOf()
        progressBar = findViewById(R.id.progressBar)
        adapter = CustomAdapter(this@MainActivity, list)
        recyclerView.layoutManager = LinearLayoutManager(this)





//        var arrayList = arrayListOf<DataItem>()
//        var newData = DataItem("satwinder",123,"babbu",342)
//           arrayList.add(newData)
//         Data().add(newData)
//         var a =Data()
//        var a = Data().add(0,newData) as Data

        //        a.add(arrayList.get(0))
        val quotesApi = RetrofitHelper.getInstance().create(QuoteApi::class.java)
        val call: Call<QuoteList> = quotesApi.getQuote()

        val btn = findViewById<Button>(R.id.button)

//        var array: ArrayList<String>
//        array = arrayListOf<String>("helloSherGill")
//        val result: Result




//        a.add(0,item)

//        result = Result("1907962","Satwinder","none","The Failure","march", "20M",30,array)



        call.enqueue(object : Callback<QuoteList?> {

                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(call: Call<QuoteList?>, response: Response<QuoteList?>) {
                    if (response.isSuccessful) {
                        progressBar.visibility = View.GONE
                        var newresponce = response.body()!!
//                           Toast.makeText(this@MainActivity, "success", Toast.LENGTH_SHORT).show()
                        Log.e("detail", "onResponse: ${response.body()}")

//                           list.clear()

                        for (myData in 1..newresponce.results.size - 1) {
                            var newData = newresponce.results[myData]
                            list.add(newData)


                            adapter.notifyDataSetChanged()
                            recyclerView.adapter = adapter
                        }

                    }


                }

                override fun onFailure(call: Call<QuoteList?>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Fail to get the data..", Toast.LENGTH_SHORT)
                        .show()
                }

            }


            )






//        var newAdapter :CustomAdapter?=null

        recyclerView = findViewById(R.id.recyclerview)


//        addData()


        // launching a new coroutine
//        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

//        GlobalScope.launch {
//            val result = quotesApi.getQuote()
//            if (result != null){
//                Log.d("ayush: ", result.body().toString())
////            println(result.body()?.results?.get(0))
//                recyclerView.apply {
//                    adapter.apply {
//                        singleAda = CustomAdapter(context,result.body())
//
//                    }
//
////      adapter = CustomAdapter(this@MainActivity,result.body())
////            adapter = this.adapter
//
//                }
//            }
//            else
//            {
//                Toast.makeText(this@MainActivity, "null", Toast.LENGTH_SHORT).show()
//            }
//            // Checking the results
//
//
//
//
//        }
//        GlobalScope.launch {
//             var result = quoteApi.getQuote().body()
//            print(result.toString())
//
////            body?.results?.let { array.addAll(it) }
////            println(array)
//
//
//        }
//        try {
//            a()
//            println(quoteApi.getQuote().body())
//
//        }
//       catch (e:Exception){
//           Log.e("exp", "onCreate: ${e.message}", )
//       }
//        }
//
//    fun a(){
//        val quoteApi = RetrofitHelper.getInstance().create(QuoteApi::class.java)
//
//        var result = quoteApi.getQuote().body()
//        print(result)
//    }


        val editText = findViewById<ImageButton>(R.id.imgbtn)
        editText.setOnClickListener{
            val intent = Intent(this@MainActivity,SearchActivity::class.java)
            startActivity(intent)
        }



//        Result("satta","satta","satta","satta","satta","satta",2, listOf("satwe","dnsin","bdewd"),)
//        var request = RetrofitHelper.getInstance()
//                var text :Int  = searchView.text
//  var jatt :Call<QuoteList> = request.

//        list.add()

        btn.setOnClickListener {
        val intent = Intent(this@MainActivity,newActivity::class.java)
            startActivity(intent)
        }

    }

//    fun addData(){
//        list.add(
//            Result("satta","vdshdvqwe","fdshqfdyu","bdhjfbs","dgeuwqg","gewhw",3,array1,)
//        )
//
//
//    }

//       if(quoteApi.getQuote().isSuccessful){
//
//               val userResponse = result.body()
//               userResponse?.results?.let {
//                   personList.addAll(it)
//                   adapter.notifyDataSetChanged()
//
//
//       }
//
//
//
//    }

//    fun searchId( id:Int){
//        when(id){
//            1->{
////                list.add()
//            }
//            2->
//            3->
//            4->
//            5->
//            6->
//            7->
//            8->
//            9->
//            10->
//            else->
//        }
//    }

}