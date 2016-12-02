package me.mx1700.http

import javax.ws.rs.container.ContainerResponseFilter
import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.container.ContainerResponseContext
import java.io.IOException
import javax.ws.rs.ext.Provider

@Provider
class PoweredByResponseFilter : ContainerResponseFilter {
    @Throws(IOException::class)
    override fun filter(requestContext: ContainerRequestContext, responseContext: ContainerResponseContext) {
        responseContext.headers.add("X-Powered-By", "Jersey :-)")
    }
}