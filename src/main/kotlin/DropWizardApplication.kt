import configuration.di.DependencyInjectionBundle
import dto.Todo
import io.dropwizard.core.Application
import io.dropwizard.core.setup.Bootstrap
import io.dropwizard.core.setup.Environment
import io.dropwizard.db.PooledDataSourceFactory
import io.dropwizard.hibernate.HibernateBundle
import repository.MutableMapTodoRepository
import resource.TodoResource
import service.TodoService

class DropWizardApplication: Application<DropWizardConfiguration>() {
    val hibernateBundle: HibernateBundle<DropWizardConfiguration?> = object : HibernateBundle<DropWizardConfiguration?>(
        Todo::class.java
    ) {
        override fun getDataSourceFactory(configuration: DropWizardConfiguration?): PooledDataSourceFactory? {
            return configuration?.datasourceFactory
        }
    }

    val dependencyInjectionBundle = DependencyInjectionBundle()

    companion object {
        @JvmStatic
        public fun main(args: Array<String>) {
            DropWizardApplication().run(*args)
        }
    }

    override fun initialize(bootstrap: Bootstrap<DropWizardConfiguration>?) {
        super.initialize(bootstrap)
        bootstrap?.addBundle(hibernateBundle)
        bootstrap?.addBundle(dependencyInjectionBundle)
    }

    override fun run(configuration: DropWizardConfiguration?, environment: Environment?) {
        dependencyInjectionBundle.run(configuration, environment)
        environment?.jersey()?.register(TodoResource::class.java)
    }
}