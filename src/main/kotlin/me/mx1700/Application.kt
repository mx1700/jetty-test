package me.mx1700

import org.glassfish.hk2.utilities.binding.AbstractBinder
import org.glassfish.jersey.server.ResourceConfig
import javax.ws.rs.ApplicationPath
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature

@ApplicationPath("/")
class Application : ResourceConfig() {
    init {
        register(ApplicationBinder())
        //自动扫描的包，包括 Resource 与 其他注解组件
        //Listener 也需要扫描
        packages(true, "me.mx1700")

        //打开角色权限控制
        register(RolesAllowedDynamicFeature::class.java)
    }
}

/**
 * 自动以注入配置类
 */
class ApplicationBinder : AbstractBinder() {
    override fun configure() {
        //手动指定注入对象
        bind("2.0.1").named("version")
    }
}