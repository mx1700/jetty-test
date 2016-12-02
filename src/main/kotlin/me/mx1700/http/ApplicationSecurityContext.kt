package me.mx1700.http

import me.mx1700.http.auth.User
import java.security.Principal
import javax.ws.rs.core.SecurityContext


class ApplicationSecurityContext(
        private val user: User,
        private val scheme: String
) : SecurityContext {

    override fun isUserInRole(role: String?): Boolean {
        return user.roles.contains(role)
    }

    override fun getAuthenticationScheme(): String {
        return SecurityContext.BASIC_AUTH;
    }

    override fun getUserPrincipal(): Principal {
        return user;
    }

    override fun isSecure(): Boolean {
        return "https" == this.scheme;
    }
}