package com.salim.android.coroutinedemo.practiceviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.salim.android.coroutinedemo.R

class SecondActivity : AppCompatActivity() {

    private lateinit var secondActivityViewModel: SecondActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        secondActivityViewModel = ViewModelProvider(this)[SecondActivityViewModel::class.java]
//        secondActivityViewModel.getUserData()
        secondActivityViewModel.usersSecond.observe(this, Observer {myUser->
            myUser?.forEach{
                Log.i("MyTag", "onCreate: name is ${it.name}")
            }
        })
    }
}