package application.app

import application.domain.contract.UseCaseContract
import locator.inject

class App {

    private val useCase: UseCaseContract by lazy { inject() }

    fun start() {
        println(useCase.start())
    }
}
