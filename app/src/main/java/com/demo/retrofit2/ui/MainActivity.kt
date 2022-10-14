package com.demo.retrofit2.ui

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.demo.retrofit2.R
import com.demo.retrofit2.repository.Repository
import com.demo.retrofit2.viewmodel.MainViewModel
import com.demo.retrofit2.viewmodel.MainViewModelFactory
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {


    lateinit var btn : Button
    lateinit var proges:ProgressBar

    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.btn)
        proges = findViewById(R.id.proges)

        var repository = Repository()
        var mainViewModelFactory = MainViewModelFactory(repository)
         var viewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)


        btn.setOnClickListener {
            proges.visibility=View.VISIBLE
            viewModel.getdata()

        }

        viewModel.data.observe(this)
        {
            if(it.isSuccessful) {
                findViewById<TextView>(R.id.text).text = it.body()!!.fanpage
                Log.d("DATA", it.body()!!.noihoc)
                Log.d("DATA",it.body()!!.monhoc)
                Log.d("DATA",it.body()!!.website)
                Log.d("DATA",it.body()!!.logo )
                proges.visibility=View.GONE
            }
            else
            {
                Log.d("DATA",it.errorBody().toString())
                findViewById<TextView>(R.id.text).text = it.code().toString()
                Toast.makeText(this,it.errorBody().toString(),Toast.LENGTH_SHORT).show()
                proges.visibility=View.GONE
            }
        }



    }
}