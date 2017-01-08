package me.mx1700.http.resource

import me.mx1700.http.auth.User
import javax.annotation.security.RolesAllowed
import javax.inject.Inject
import javax.inject.Named
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.SecurityContext

@Path("foo")
class FooResource {

    @Inject
    @Named("version")
    private lateinit var version: String;

    @Context
    private lateinit var security: SecurityContext;

//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    @RolesAllowed("user")
//    fun getIt(@Context securityContext: SecurityContext): String {
//        return "Got it890!" + version + "-user:" + securityContext.user?.id
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    fun getIt(): Any {
        //return User(1, "zhang", "asd@gmail.com", "123456", arrayOf())
        return (1..5).map{
            object {
                val id = security.user.id
                val name = "zhang $it"
                val version = this@FooResource.version
            }
        }
    }
}