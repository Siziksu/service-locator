package application

import application.app.Presenter
import application.app.PresenterContract
import application.data.repository.AnotherRepository
import application.data.repository.StringRepository
import application.data.repository.contract.AnotherRepositoryContract
import application.data.repository.contract.StringRepositoryContract
import application.domain.contract.UseCaseContract
import locator.GlobalContext
import locator.inject
import locator.module
import locator.startLocator
import locator.stopLocator
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AppTest {

    @Before
    fun before() {
        stopLocator()

        startLocator {
            modules(module {
                set<AnotherRepositoryContract>(AnotherRepository())
                set<StringRepositoryContract>(StringRepository())
                set<UseCaseContract>(UseCaseMock())
                set<PresenterContract>(Presenter())
            })
        }

        val stringRepository = GlobalContext.locator().get<StringRepositoryContract>()
        stringRepository.set("name", "Esteban")
    }

    @Test
    fun testApp() {
        val useCase: UseCaseContract by lazy { inject() }
        assertEquals("Guillaume", useCase.start())
    }

    @Test
    fun testPresenter() {
        val presenter: PresenterContract by lazy { inject() }
        assertEquals("Guillaume", presenter.start())
    }
}
