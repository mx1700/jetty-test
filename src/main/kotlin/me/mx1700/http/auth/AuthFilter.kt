package me.mx1700.http.auth

import javax.ws.rs.ext.Provider
import me.mx1700.http.ApplicationSecurityContext
import javax.ws.rs.container.*


@Provider
@PreMatching    //TODO:不知道什么作用
class AuthFilter : ContainerRequestFilter {
    override fun filter(requestContext: ContainerRequestContext) {
        //println("AuthFilter!!!")
//        val auth = requestContext.getHeaderString("authorization")
//        if (auth == null) {
//            return
//        }
//        val lap = BasicAuth.decode(auth)
//        if(lap == null || lap.size != 2) {
//            throw WebApplicationException(Response.Status.UNAUTHORIZED);
//        }
//        val (email, password) = lap
        //TODO:数据库验证用户
        val user = User(12, "test001", "mx1700@gmail.com", "123456", arrayOf("user"))
        val scheme = requestContext.uriInfo.requestUri.scheme
        requestContext.securityContext = ApplicationSecurityContext(user, scheme)
    }
}