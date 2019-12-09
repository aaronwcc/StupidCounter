package com.example.stupidcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
// Declare an instance of the ViewModel
    private lateinit var counterViewModel: CounterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialise the ViewMOdel
        counterViewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)

        // add an observer to the viewmodel
        counterViewModel.counter.observe(this, Observer {
            if (counterViewModel.counter.value == 10) {
                goodJob()}
        })




        btnIncrease.setOnClickListener {
             counterViewModel.increment()
            tvCounter.text = counterViewModel.counter.value.toString()
        }


        btnDecrease.setOnClickListener {
            counterViewModel.decrement()
            tvCounter.text = counterViewModel.counter.value.toString()
        }

    }

    private fun goodJob(){
        Toast.makeText(applicationContext,  "Congratz", Toast.LENGTH_LONG).show()
    }
}
