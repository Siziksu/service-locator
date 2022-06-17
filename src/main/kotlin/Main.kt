import application.app.App
import application.data.repository.contract.StringRepositoryContract
import application.di.appModule
import locator.GlobalContext
import locator.startLocator

fun main() {
    initLocator()
    App().start()
}

internal fun initLocator() {
    startLocator {
        modules(appModule)
    }
    val stringRepository = GlobalContext.locator().get<StringRepositoryContract>()
    stringRepository.set("name", "Esteban")
}
