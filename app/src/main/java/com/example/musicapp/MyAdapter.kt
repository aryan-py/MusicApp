package com.example.musicapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class MyAdapter(val context: Activity, val dataList : List<Data>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // populate the data into the view
        val currentData = dataList[position]

        holder.title.text=currentData.title
        Picasso.get().load(currentData.album.cover).into(holder.image)
      }
    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // create the view in case the layout manager fails to create the view for the data
        val itemView=LayoutInflater.from(context).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(itemView)
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image : ImageView
        val title : TextView


        init{
            image=itemView.findViewById(R.id.musicImage)
            title=itemView.findViewById(R.id.musicTitle)
        }
    }
}