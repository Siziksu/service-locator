package application.app

import application.domain.contract.UseCaseContract
import locator.inject

class Presenter {

    private val useCase: UseCaseContract by lazy { inject() }

    fun start(): String {
        return useCase.start()
    }
}