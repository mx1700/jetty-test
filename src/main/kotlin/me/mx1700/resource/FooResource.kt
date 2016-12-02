package me.mx1700.resource

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
    private var version = "123"

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("user")
    fun getIt(@Context securityContext: SecurityContext): String {
        return "Got it123!" + version + "-user:" + securityContext.user?.id
    }
}