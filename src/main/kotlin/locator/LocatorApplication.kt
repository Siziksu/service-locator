package locator

import kotlin.reflect.KType
import kotlin.reflect.typeOf

class LocatorApplication private constructor() {

    val hash = HashMap<KType, Any>()

    fun modules(module: Module): LocatorApplication {
        modules(listOf(module))
        return this
    }

    fun modules(modules: List<Module>): LocatorApplication {
        loadModules(modules)
        return this
    }

    inline fun <reified T> get(): T {
        return hash[typeOf<T>()] as? T ?: throw Exception("Bean ${(T::class).simpleName ?: typeOf<T>()} not defined")
    }

    private fun loadModules(modules: List<Module>) {
        modules.forEach { module ->
            module.hash.forEach {
                hash[it.key] = it.value
            }
        }
    }

    companion object {

        fun init(): LocatorApplication {
            return LocatorApplication()
        }
    }
}
