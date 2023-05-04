package com.example.retrofitdemo.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.R
import com.example.retrofitdemo.Result

class SearchAdapter2(var context: Context, val mList: MutableList<Result>) : RecyclerView.Adapter<SearchAdapter2.ViewHolder>() {


//    private lateinit var layoutInflater:LayoutInflater
//    private lateinit var arryListDetails :ArrayList<Data>






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       var view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item,parent,false)
       return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (mList != null) {
            holder.bindView(mList[position])
        }


    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView)  {
        var name = itemView.findViewById<TextView>(R.id.textView)
        var id = itemView.findViewById<TextView>(R.id.textView2)
        var Quote = itemView.findViewById<TextView>(R.id.textView3)


        fun bindView(result: Result){
            name.text = result.name
            id.text = result.bio
            Quote.text = result.dateModified
//            name.text = result.author
//            id.text = result._id
//            Quote.text = result.content
//            Log.e("thebigdata", "onBindViewHolder: ${id.text}", )

        }
    }
}