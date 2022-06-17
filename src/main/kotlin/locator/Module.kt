package locator

import kotlin.reflect.KType
import kotlin.reflect.typeOf

class Module {

    val hash = HashMap<KType, Any>()

    inline fun <reified T : Any> set(obj: T) {
        hash[typeOf<T>()] = obj
    }
}
