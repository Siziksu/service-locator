package resources.di

import application.app.Presenter
import application.app.PresenterContract
import application.data.repository.AnotherRepository
import application.data.repository.StringRepository
import application.data.repository.contract.AnotherRepositoryContract
import application.data.repository.contract.StringRepositoryContract
import application.domain.contract.UseCaseContract
import locator.module
import resources.mock.domain.UseCaseMock

internal val appModuleTest = module {
    set<PresenterContract>(Presenter())
}

internal val domainModuleTest = module {
    set<UseCaseContract>(UseCaseMock())
}

internal val dataModuleTest = module {
    set<AnotherRepositoryContract>(AnotherRepository())
    set<StringRepositoryContract>(StringRepository())
}