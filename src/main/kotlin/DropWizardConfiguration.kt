import configuration.di.DependecnyInjectionConfiguration
import configuration.di.NamedProperty
import io.dropwizard.core.Configuration
import resource.TodoResource
import service.TodoService
import kotlin.reflect.KClass

class DropWizardConfiguration: Configuration(), DependecnyInjectionConfiguration {
    val environment: String = "dev"

    override fun getSingletons(): List<Class<*>> {
        return listOf(
        )
    }

    override fun getNamedProperties(): List<NamedProperty<out Any>> {
        return listOf(
        )
    }
}