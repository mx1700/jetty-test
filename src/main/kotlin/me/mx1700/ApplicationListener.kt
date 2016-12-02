package me.mx1700

import org.glassfish.hk2.api.DynamicConfigurationService
import org.glassfish.hk2.api.MultiException
import org.glassfish.hk2.api.ServiceLocator
import org.glassfish.jersey.server.monitoring.ApplicationEvent
import org.glassfish.jersey.server.monitoring.ApplicationEventListener
import org.glassfish.jersey.server.monitoring.RequestEvent
import org.glassfish.jersey.server.monitoring.RequestEventListener
import java.io.IOException
import javax.inject.Inject
import javax.ws.rs.ext.Provider

@Provider
class ApplicationListener : ApplicationEventListener {

    @Inject
    private lateinit var serviceLocator: ServiceLocator

    override fun onEvent(event: ApplicationEvent) {
        when (event.type) {
            ApplicationEvent.Type.INITIALIZATION_FINISHED -> onInitFinished()
            else -> {
            }
        }
    }
    override fun onRequest(requestEvent: RequestEvent): RequestEventListener? {
        return null
    }

    private fun onInitFinished() {
        populate(serviceLocator)
    }

    /**
     * 自动扫描所有 service
     * @param serviceLocator
     */
    private fun populate(serviceLocator: ServiceLocator) {
        val dcs = serviceLocator.getService(DynamicConfigurationService::class.java)
        val populator = dcs.populator
        try {
            populator.populate()
        } catch (e: IOException) {
            throw MultiException(e)
        } catch (e: MultiException) {
            throw MultiException(e)
        }
    }
}