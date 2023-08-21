import com.fasterxml.jackson.annotation.JsonProperty
import configuration.di.DependecnyInjectionConfiguration
import configuration.di.NamedProperty
import io.dropwizard.core.Configuration
import io.dropwizard.db.DataSourceFactory
import repository.MutableMapTodoRepository
import repository.TodoRepository
import resource.TodoResource
import service.TodoInterface
import service.TodoService

class DropWizardConfiguration: Configuration(), DependecnyInjectionConfiguration {
    val environment: String = "dev"
    @get:JsonProperty("database")
    @set:JsonProperty("database")
    var datasourceFactory: DataSourceFactory = DataSourceFactory()

    override fun getSingletons(): List<Pair<Class<*>, Class<*>>> {
        return mutableListOf(
            Pair(TodoService::class.java, TodoInterface::class.java),
            Pair(MutableMapTodoRepository::class.java, TodoRepository::class.java)
        )
    }

    override fun getNamedProperties(): List<NamedProperty<out Any>> {
        return listOf()
    }
}