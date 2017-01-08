package me.mx1700.http.resource

import me.mx1700.http.auth.User
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.Response
import javax.ws.rs.core.SecurityContext

/**
 * 获取当前用户
 */
val SecurityContext.user: User
    get() {
        if (userPrincipal == null) {
            throw WebApplicationException(Response.Status.UNAUTHORIZED)
        }
        return userPrincipal as User
    }

/**
 * 获取当前用户
 */
val SecurityContext.existUser: User?
    get() = userPrincipal as User
