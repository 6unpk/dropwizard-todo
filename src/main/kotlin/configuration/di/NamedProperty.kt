package configuration.di

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import kotlin.reflect.KClass

data class NamedProperty<T : Any> @JsonCreator constructor(
    @JsonProperty("id")
    val id: String,
    @JsonProperty("value")
    val value: T,
    @JsonProperty("clazz")
    val clazz: Class<T>
)