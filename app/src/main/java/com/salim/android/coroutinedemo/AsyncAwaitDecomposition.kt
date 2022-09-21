package com.salim.android.coroutinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AsyncAwaitDecomposition : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_await_decomposition)


        //Change IO -> Main because we want to show toast
        CoroutineScope(Main).launch {
            Log.i("MyTag", "Calculation started.....")
//            val stock1 = getStock1()
//            val stock2 = getStock2()

            //use this for use async
            //use parameter async with IO
            val stock1 = async(IO) {  getStock1() }
            val stock2 = async(IO) {  getStock2() }

            val total = stock1.await() + stock2.await()
            Toast.makeText(applicationContext, "$total", Toast.LENGTH_LONG).show()
            Log.i("MyTag", "Total is $total")
        }
    }
}

private suspend fun getStock1(): Int{
    delay(10000)
    Log.i("MyTag", "getStock1: stock 1 returned")
    return 55000
}

private suspend fun getStock2(): Int{
    delay(8000)
    Log.i("MyTag", "getStock2: stock 2 returned")
    return 35000
}