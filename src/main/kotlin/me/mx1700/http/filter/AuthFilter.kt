package me.mx1700.http.filter

import javax.ws.rs.ext.Provider
import me.mx1700.http.ApplicationSecurityContext
import me.mx1700.http.auth.User
import me.mx1700.services.UserService
import javax.inject.Inject
import javax.inject.Named
import javax.ws.rs.container.*


@Provider
@PreMatching //TODO:不知道什么作用
class AuthFilter : ContainerRequestFilter {

    @Inject
    private lateinit var userService: UserService

    override fun filter(requestContext: ContainerRequestContext) {
//        println("AuthFilter!!!")
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
        val user = userService.getUser(1)
        val scheme = requestContext.uriInfo.requestUri.scheme
        requestContext.securityContext = ApplicationSecurityContext(user, scheme)
    }
}