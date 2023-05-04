package com.example.retrofitdemo.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.R
import com.example.retrofitdemo.activity.newActivity
import com.example.retrofitdemo.dataclass.DataItem


class CustomAdapter2(val mList: MutableList<DataItem>, var newActivity: newActivity) : RecyclerView.Adapter<CustomAdapter2.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       var view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item2,parent,false)
       return ViewHolder(view)
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView)  {
//        var name = itemView.findViewById<TextView>(R.id.nameId)
//        var name = itemView.findViewById(R.id) as TextView
        var name:TextView =ItemView.findViewById(R.id.nameId)
        var id = itemView.findViewById<TextView>(R.id.textid)
        var Quote = itemView.findViewById<TextView>(R.id.quote)
        var dlt = itemView.findViewById<ImageView>(R.id.imageView)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.e("showData","okk"+mList)
        holder.apply {

            name.setText(mList[position].title)
            id.text = mList[position].id.toString()
            Quote.text = mList[position].body
            dlt.setOnClickListener {
                mList.removeAt(position)
                notifyItemRemoved(position)
            }

        }

//        if (mList != null) {
//            holder.bindView2(mList[position])
//        }
//        else{
//            Log.e("detail", "onBindViewHolder: emptyOrNull", )
//        }


    }

}