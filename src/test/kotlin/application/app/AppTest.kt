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
import resources.di.dataModuleTest
import resources.di.domainModuleTest

class AppTest {

    @Before
    fun before() {
        stopLocator()

        startLocator {
            modules(
                appModuleTest,
                domainModuleTest,
                dataModuleTest
            )
        }

        val stringRepository = GlobalContext.locator.get<StringRepositoryContract>()
        stringRepository.set("name", "Esteban")
    }

    @Test
    fun testApp() {
        val useCase: UseCaseContract by inject()
        assertEquals("Guillaume", useCase.start())
    }

    @Test
    fun testPresenter() {
        val presenter: PresenterContract by inject()
        assertEquals("Guillaume", presenter.start())
    }

    @Test
    fun testStringRepository() {
        val stringRepository: StringRepositoryContract by inject()
        assertEquals("Esteban", stringRepository.get("name"))
    }

    @Test
    fun anotherRepository() {
        val anotherRepository: AnotherRepositoryContract by inject()
        assertEquals("Another repository function", anotherRepository.function())
    }
}
