package com.example.lab10

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.w3c.dom.Text


class StreamAdapter (private val list: ArrayList<Post>, private val context:Context): RecyclerView.Adapter<StreamAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItem(post:Post){
            var name: TextView = itemView.findViewById(R.id.nameTXT) as TextView
            var desc: TextView = itemView.findViewById(R.id.descTXT) as TextView
            name.text = post.name;
            desc.text = post.desc;
            Log.d("adapterStreamAdapter", post.toString())
            itemView.setOnClickListener{
                Toast.makeText(context, post.name, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }


}