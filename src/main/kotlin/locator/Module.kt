package locator

import kotlin.reflect.typeOf

class Module {

    val hash = HashMap<String, Any>()

    inline fun <reified T : Any> set(obj: T) {
        hash["${typeOf<T>()}"] = obj
    }
}
