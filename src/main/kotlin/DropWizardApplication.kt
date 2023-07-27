import configuration.di.DependencyInjectionBundle
import io.dropwizard.core.Application
import io.dropwizard.core.setup.Bootstrap
import io.dropwizard.core.setup.Environment

class DropWizardApplication: Application<DropWizardConfiguration>() {
    companion object {
        @JvmStatic
        public fun main(args: Array<String>) {
            DropWizardApplication().run(*args)
        }
    }

    override fun initialize(bootstrap: Bootstrap<DropWizardConfiguration>?) {
        super.initialize(bootstrap)
    }

    override fun run(configuration: DropWizardConfiguration?, environment: Environment?) {
        DependencyInjectionBundle().apply {
            run(configuration, environment)
        }
    }
}