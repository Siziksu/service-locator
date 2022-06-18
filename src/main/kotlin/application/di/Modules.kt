package application.di

import application.app.Presenter
import application.app.PresenterContract
import application.data.repository.AnotherRepository
import application.data.repository.StringRepository
import application.data.repository.contract.AnotherRepositoryContract
import application.data.repository.contract.StringRepositoryContract
import application.domain.UseCase
import application.domain.contract.UseCaseContract
import locator.module

internal val appModule = module {
    set<PresenterContract>(Presenter(inject()))
}

internal val domainModule = module {
    set<UseCaseContract>(UseCase(inject(), inject()))
}

internal val dataModule = module {
    set<AnotherRepositoryContract>(AnotherRepository())
    set<StringRepositoryContract>(StringRepository())
}
