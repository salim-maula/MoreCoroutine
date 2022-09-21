package com.salim.android.coroutinedemo.practiceviewmodel.model

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUSers() : List<User> {
        delay(8000)
        val users: List<User> = listOf(
            User(1, "nano"),
            User(2, "nani"),
            User(3, "nana"),
            User(4, "nanu"),
        )
        return users
    }
}