package com.example.lab10

import android.content.Context
import android.content.Intent as Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.firebase.firestore.FirebaseFirestore
import org.w3c.dom.Text
import com.example.lab10.Stream


class StreamAdapter (private val list: ArrayList<Post>, private val context:Context): RecyclerView.Adapter<StreamAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItem(post:Post){
            var name: TextView = itemView.findViewById(R.id.nameTXT) as TextView
            var desc: TextView = itemView.findViewById(R.id.descTXT) as TextView
            name.text = post.name;
            desc.text = post.desc;
            Log.d("adapterStreamAdapter", post.toString())
            itemView.setOnClickListener {
                //deletePost(post)
                var i = Intent(context, Stream::class.java)
//                context.startActivity(i)
//                Toast.makeText(context, post.name, Toast.LENGTH_SHORT).show()
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

    fun deletePost(p:Post){
        val db = FirebaseFirestore.getInstance()
        db.collection("Post").document(p.id.toString()).delete().addOnSuccessListener {
            Toast.makeText(context, "Successfully deleted user", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener { Toast.makeText(context, "Unable to delete user", Toast.LENGTH_SHORT).show() }

        //Customer: is your database collection name.  It is case sensitive.
//        db.collection("Post").whereEqualTo("name",p.name).get().
//            .delete()
//            .addOnSuccessListener { Log.d("Delete", "DocumentSnapshot successfully deleted!") }
//            .addOnFailureListener { e -> Log.w("Delete", "Error deleting document", e) }

    }
}