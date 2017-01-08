package me.mx1700.services

import me.mx1700.http.auth.User
import org.jvnet.hk2.annotations.Service

@Service
class UserService() {
    fun getUser(id: Int): User {
        return User(12, "test001", "mx1700@gmail.com", "123456", arrayOf("user"))
    }
}