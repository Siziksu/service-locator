package application.app

import locator.inject

class App {

    private val presenter: PresenterContract by lazy { inject() }

    fun start() {
        println(presenter.start())
    }
}
