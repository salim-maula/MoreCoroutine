package com.salim.android.coroutinedemo

class SuspendDemo {

    private fun firstFunction(){

    }

    //we use suspending function to avoid theread blocking and hence to provide smooth,
    // uninterrupted experience

    //why use suspend
    //this function can get paused when code block 2(long running operation)
    // starts executing
    // and get resumed when it is done
    private suspend fun secondFunction(){

    }
}