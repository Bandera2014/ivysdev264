package com.example.lab08

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.SeekBar.*
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var slider:  SeekBar
        lateinit var value:  TextView
        slider=mySeekBar
        value=myPizzaSize
        val pizzaSize = arrayListOf<String>("Please Select","Small","Medium","Large","Extra-Large")

        slider.setOnSeekBarChangeListener(object: OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                value.text=pizzaSize[progress]
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        dateBTN.setOnClickListener{
            val c = Calendar.getInstance()
            val day = c.get(Calendar.DAY_OF_MONTH)
            val month = c.get(Calendar.MONTH)
            val year = c.get(Calendar.YEAR)
            val myDatePicker = DatePickerDialog(this,android.R.style.ThemeOverlay,DatePickerDialog.OnDateSetListener{
                DatePicker,Year,Month,Day -> dateText.text="$Day / ${Month+1} / $Year"},year,month,day
            )
            myDatePicker.show()
        }

        timeBTN.setOnClickListener {
            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minutes = c.get(Calendar.MINUTE)

            val myTimePicker = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener{
                TimePicker,hourOfDay,minute -> timeText.text="$hourOfDay : $minute"},hour,minutes,true)
            Log.d("time issue", "timeissue:"+ (hour + minutes).toString())
            myTimePicker.show()
            }

        scheduleBTN.setOnClickListener {
            var i = Intent(this,Thanks::class.java)
            i.putExtra("name",myFullName.text.toString())
            i.putExtra("phoneNumber",myPhoneNumber.text.toString())
            i.putExtra("pizzaSize",myPizzaSize.text.toString())
            i.putExtra("pickupDate",dateText.text.toString())
            i.putExtra("pickupTime",timeText.text.toString())

            startActivity(i)
        }
    }
}
