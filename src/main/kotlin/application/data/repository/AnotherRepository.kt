package application.data.repository

import application.data.repository.contract.AnotherRepositoryContract

class AnotherRepository : AnotherRepositoryContract {

    override fun function(): String = "Another repository function"
}
