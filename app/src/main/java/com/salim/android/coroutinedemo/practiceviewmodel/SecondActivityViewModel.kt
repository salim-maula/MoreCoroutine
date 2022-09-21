package com.salim.android.coroutinedemo.practiceviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.salim.android.coroutinedemo.practiceviewmodel.model.User
import com.salim.android.coroutinedemo.practiceviewmodel.model.UserRepository
import kotlinx.coroutines.*

class SecondActivityViewModel: ViewModel() {

    private var userRepository = UserRepository()
    var users : MutableLiveData<List<User>?> = MutableLiveData()

    //tidak perlu menggunkan ini jika menggunakan viewmodelscope
//    private val myJob = Job()
//    private val myScope = CoroutineScope(Dispatchers.IO + myJob)


    var usersSecond = liveData(Dispatchers.IO){
        val result = userRepository.getUSers()
        emit(result)
    }

    fun getUserData(){

        //just change with viewmodelscope
//        myScope.launch {
//            //write some code
//        }


            viewModelScope.launch {
                var result : List<User>? = null
                withContext(Dispatchers.IO){
                    result = userRepository.getUSers()
                }
                users.value = result
            }

    }

    //tidak perlu menggunkan ini jika menggunakan viewmodelscope
//    override fun onCleared() {
//        super.onCleared()
//        myJob.cancel()
//    }
}