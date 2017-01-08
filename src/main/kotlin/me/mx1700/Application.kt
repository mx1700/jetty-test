package me.mx1700

import org.glassfish.hk2.utilities.binding.AbstractBinder
import org.glassfish.jersey.server.ResourceConfig
import javax.ws.rs.ApplicationPath
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature

@ApplicationPath("/")
class Application : ResourceConfig() {
    init {
        register(ApplicationBinder())
        /*
         * 设置需要自动扫描的包
         * @Service 类不需要扫描，因为 @Service 类是编译进特殊配置文件中
         */
        packages(false, "me.mx1700")
        packages(false, "me.mx1700.http")
        packages(false, "me.mx1700.http.filter")
        packages(false, "me.mx1700.http.resource")

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