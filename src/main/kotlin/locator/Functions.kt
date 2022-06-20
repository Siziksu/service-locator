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

/**
 * The default thread-safety mode for lazy is LazyThreadSafetyMode.SYNCHRONIZED.
 */
inline fun <reified T : Any> inject(): Lazy<T> = lazy { GlobalContext.locator.get() }
