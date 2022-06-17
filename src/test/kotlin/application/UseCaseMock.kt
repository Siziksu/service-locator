package application

import application.domain.contract.UseCaseContract

class UseCaseMock: UseCaseContract {

    override fun start(): String {
        return "Guillaume"
    }
}
