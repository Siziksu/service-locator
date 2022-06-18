package application.domain

import application.data.repository.contract.AnotherRepositoryContract
import application.data.repository.contract.StringRepositoryContract
import application.domain.contract.UseCaseContract

class UseCase(
    private val stringRepository: Lazy<StringRepositoryContract>,
    private val anotherRepository: Lazy<AnotherRepositoryContract>
) : UseCaseContract {

    override fun start(): String = "${stringRepository.value.get("name")}\n${anotherRepository.value.function()}"
}
