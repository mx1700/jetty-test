package me.mx1700.http.auth

import java.security.Principal

/**
 * Created by lizhaoguang on 16/12/3.
 */
class User(
        val id: Int,
        private val _name: String,
        val email: String,
        val password: String,
        val roles: Array<String>
) : Principal {

    override fun getName(): String {
        return _name
    }

}