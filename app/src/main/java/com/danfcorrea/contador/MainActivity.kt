package com.danfcorrea.contador

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var counterTextView: TextView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterTextView = findViewById(R.id.tvCounter)
        sharedPreferences = getPreferences(MODE_PRIVATE)
        val counter = sharedPreferences.getInt("counter", 0)
        counterTextView.text = counter.toString()
    }

    fun incrementCounter(view: View) {
        val counter = counterTextView.text.toString().toInt()
        counterTextView.text = (counter + 1).toString()
    }
    fun decrementCounter(view: View) {
        val counter = counterTextView.text.toString().toInt()
        if(counter > 0)
            counterTextView.text = (counter - 1).toString()
    }
    fun resetCounter(view: View) {
        val counter = counterTextView.text.toString().toInt()
        counterTextView.text = 0.toString()
    }

    override fun onPause() {
        super.onPause()
        val counter = counterTextView.text.toString().toInt()
        val editor = sharedPreferences.edit()
        editor.putInt("counter", counter)
        editor.apply()
    }


}