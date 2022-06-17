package application.app

import application.data.repository.contract.AnotherRepositoryContract
import application.data.repository.contract.StringRepositoryContract
import application.domain.contract.UseCaseContract
import locator.GlobalContext
import locator.inject
import locator.startLocator
import locator.stopLocator
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import resources.di.appModuleTest

class AppTest {

    @Before
    fun before() {
        stopLocator()

        startLocator {
            modules(appModuleTest)
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

    @Test
    fun testStringRepository() {
        val stringRepository: StringRepositoryContract by lazy { inject() }
        assertEquals("Esteban", stringRepository.get("name"))
    }

    @Test
    fun anotherRepository() {
        val anotherRepository: AnotherRepositoryContract by lazy { inject() }
        assertEquals("Another repository function", anotherRepository.function())
    }
}
