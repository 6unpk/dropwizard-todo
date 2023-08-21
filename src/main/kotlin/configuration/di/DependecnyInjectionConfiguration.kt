package configuration.di

import kotlin.reflect.KClass

interface DependecnyInjectionConfiguration {
    fun getSingletons(): List<Pair<Class<*>, Class<*>>>
    fun getNamedProperties(): List<NamedProperty<out Any>>
}