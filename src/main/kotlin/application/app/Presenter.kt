package application.app

import application.domain.contract.UseCaseContract

class Presenter(private val useCase: Lazy<UseCaseContract>) : PresenterContract {

    override fun start(): String {
        return useCase.value.start()
    }
}
