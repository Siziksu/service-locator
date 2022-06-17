package locator

fun startLocator(appDeclaration: LocatorApplication.() -> Unit): LocatorApplication {
    return GlobalContext.startLocator(appDeclaration)
}

fun stopLocator() = GlobalContext.stopLocator()

fun module(definition: Module.() -> Unit): Module {
    val module = Module()
    definition(module)
    return module
}

inline fun <reified T> inject(): T = GlobalContext.locator().get()
