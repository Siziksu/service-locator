import application.app.App
import application.data.repository.contract.StringRepositoryContract
import application.di.appModule
import application.di.dataModule
import application.di.domainModule
import locator.GlobalContext
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
    val stringRepository = GlobalContext.locator.get<StringRepositoryContract>()
    stringRepository.set("name", "Esteban")
}
