package configuration.di

import io.dropwizard.core.ConfiguredBundle
import io.dropwizard.core.setup.Environment
import jakarta.inject.Singleton
import org.glassfish.hk2.utilities.binding.AbstractBinder
import org.glassfish.jersey.internal.inject.Injections

class DependencyInjectionBundle: ConfiguredBundle<DependecnyInjectionConfiguration> {
    override fun run(configuration: DependecnyInjectionConfiguration?, environment: Environment?) {
        environment?.jersey()?.register(
            object: AbstractBinder() {
                override fun configure() {
                    for (singletonClass in configuration?.getSingletons()!!) {
                        bind(singletonClass.first).to(singletonClass.second).`in`(Singleton::class.java)
                    }

                    for (namedProperty in configuration.getNamedProperties()) {
                        bind(namedProperty.value as Any?).to(namedProperty.clazz as Class<Any?>?)
                            .named(namedProperty.id)
                    }
                }
            }
        )
    }
}