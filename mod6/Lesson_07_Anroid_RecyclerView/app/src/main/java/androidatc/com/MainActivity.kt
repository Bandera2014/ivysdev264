package androidatc.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidatc.com.data.PlaceListAdapter
import androidatc.com.model.Place
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var adapter: PlaceListAdapter?=null
    private var countryList:ArrayList<Place>?=null
    private var layoutManager: RecyclerView.LayoutManager?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countryList= ArrayList<Place>()
        layoutManager= LinearLayoutManager(this)
        adapter=PlaceListAdapter(countryList!!,this)

        myRecyclerView.layoutManager = layoutManager
        myRecyclerView.adapter = adapter

        //loadData
        var countrynameList:Array<String> = arrayOf("Canada","USA","Mexico","Columbia","malaysia",
                                                    "Singapore","Turkey","Nicaragua","India","Italy"
                                                    ,"Tunisia", "Chile","Argentina","Spain","Peru")
        var citiesNameList:Array<String> = arrayOf("Ottawa","Washington DC","Mexico City","Bogota",
                                                "Kuala Lumpur","Singapore","Ankara","Managua","New Delhi",
                                                "Rome","tunis","Santiago","Buenos Aires", "Madrid","Lima")
        for(i in 0..14){
            var place=Place()
            place.countryName = countrynameList[i]
            place.cityName = citiesNameList[i]
            countryList?.add(place)
            Log.d("Nothing", countrynameList[i])
        }

        adapter!!.notifyDataSetChanged()

    }

}