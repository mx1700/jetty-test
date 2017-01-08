package me.mx1700.http.auth

import java.security.Principal
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
class User(
        val id: Int,
        private val _name: String,
        val email: String,
        val password: String,
        val roles: Array<String>
) : Principal {

    constructor(): this(0, "", "", "", arrayOf())

    override fun getName(): String {
        return _name
    }

}