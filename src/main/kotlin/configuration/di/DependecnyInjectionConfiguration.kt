package configuration.di

import kotlin.reflect.KClass

interface DependecnyInjectionConfiguration {
    fun getSingletons(): List<Class<*>>
    fun getNamedProperties(): List<NamedProperty<out Any>>
}