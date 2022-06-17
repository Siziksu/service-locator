package resources.mock.domain

import application.domain.contract.UseCaseContract

class UseCaseMock : UseCaseContract {

    override fun start(): String = "Guillaume"
}
