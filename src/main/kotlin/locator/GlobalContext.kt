package locator

object GlobalContext {

    private var locatorApplication: LocatorApplication? = null

    val locator: LocatorApplication
        get() = locatorApplication ?: throw Exception("Locator not defined")

    private fun register(locatorApplication: LocatorApplication) {
        this.locatorApplication = locatorApplication
    }

    fun startLocator(application: LocatorApplication.() -> Unit): LocatorApplication {
        return LocatorApplication.init().apply {
            register(this)
            application()
        }
    }

    fun stopLocator() {
        locatorApplication?.apply { hash.clear() }
    }
}
