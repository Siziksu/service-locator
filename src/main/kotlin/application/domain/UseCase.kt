package application.domain

import application.data.repository.contract.AnotherRepositoryContract
import application.data.repository.contract.StringRepositoryContract
import application.domain.contract.UseCaseContract
import locator.inject

class UseCase : UseCaseContract {

    private val stringRepository: StringRepositoryContract by inject()
    private val anotherRepository: AnotherRepositoryContract by inject()

    override fun start(): String = "${stringRepository.get("name")}\n${anotherRepository.function()}"
}
