package androidatc.com.data

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidatc.com.R
import androidatc.com.model.Place
import androidx.recyclerview.widget.RecyclerView

class PlaceListAdapter(private val list:ArrayList<Place>,private val context:Context):RecyclerView.Adapter<PlaceListAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Nothing","onBindViewHolder "+list[position])
        holder.bindItem(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        //create our view from our card_layout.xml
        val view = LayoutInflater.from(context).inflate(R.layout.card_layout,parent,false)
        Log.d("Nothing","onCreateViewHolder triggered")
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("Nothing", list.size.toString())
        return list.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItem(place:Place){
            var country:TextView=itemView.findViewById(R.id.country_ID) as TextView
            var city:TextView=itemView.findViewById(R.id.city_ID) as TextView
            country.text=place.countryName
            city.text=place.cityName
            Log.d("Nothing","bindItem")

            itemView.setOnClickListener{
                Toast.makeText(context, country.text, Toast.LENGTH_SHORT).show()
            }

        }
    }

}