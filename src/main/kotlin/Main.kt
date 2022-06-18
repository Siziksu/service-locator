import application.app.App
import application.data.repository.contract.StringRepositoryContract
import application.di.appModule
import application.di.dataModule
import application.di.domainModule
import locator.inject
import locator.startLocator

fun main() {
    initLocator()
    App().start()
}

internal fun initLocator() {
    startLocator {
        modules(
            appModule,
            domainModule,
            dataModule
        )
    }
    val stringRepository: StringRepositoryContract by inject()
    stringRepository.set("name", "Esteban")
}
