package locator

object GlobalContext {

    private var locatorApplication: LocatorApplication? = null

    fun locator(): LocatorApplication = locatorApplication ?: throw Exception("Locator not defined")

    private fun register(locatorApplication: LocatorApplication) {
        this.locatorApplication = locatorApplication
    }

    fun startLocator(appDeclaration: LocatorApplication.() -> Unit): LocatorApplication {
        return LocatorApplication.init().apply {
            register(this)
            appDeclaration()
        }
    }

    fun stopLocator() {
        locatorApplication?.apply { hash.clear() }
    }
}
