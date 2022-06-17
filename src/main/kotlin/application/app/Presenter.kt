package application.app

import application.domain.contract.UseCaseContract
import locator.inject

class Presenter : PresenterContract {

    private val useCase: UseCaseContract by inject()

    override fun start(): String {
        return useCase.start()
    }
}
