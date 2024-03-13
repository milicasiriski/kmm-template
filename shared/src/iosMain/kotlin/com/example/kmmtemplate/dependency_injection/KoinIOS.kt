package com.example.kmmtemplate.dependency_injection

import com.example.kmmtemplate.data.local.KeyValueStore
import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.ObjCProtocol
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

/**
 * Dependency injection on iOS
 */
object KoinIOS {
    fun initialize(
        createKeyValueStore: () -> KeyValueStore
    ): KoinApplication = initKoin(
        platformSpecificModule = module {
            single<KeyValueStore> { createKeyValueStore() }
        }
    )
}

/**
 * Gets object of exact type [objCClass]
 * For inherited or implemented types use [Koin.get(objCProtocol: ObjCProtocol)]
 * Swift code example:
 *      let useCase: SomeUseCase = Koin.instance.get()
 */
@OptIn(BetaInteropApi::class)
fun Koin.get(objCClass: ObjCClass): Any {
    val kClazz = getOriginalKotlinClass(objCClass)!!
    return get(kClazz, null, null)
}

/**
 * Gets object of exact type [objCClass] with a String parameter [parameter]
 * For inherited or implemented types use [Koin.get(objCProtocol: ObjCProtocol)]
 * Swift code example:
 *      let useCase: SomeUseCase = Koin.instance.get(parameter: chatRoomId)
 */
@OptIn(BetaInteropApi::class)
fun Koin.get(objCClass: ObjCClass, parameter: String): Any {
    val kClazz = getOriginalKotlinClass(objCClass)!!
    return get(kClazz, null) { parametersOf(parameter) }
}

/**
 * Gets object of type which conforms to the [objCProtocol]
 * Use when getting types that inherit/implement [objCProtocol]
 * Swift code example:
 *      let service: Service = Koin.instance.get(objCProtocol: Service.self)
 */
@OptIn(BetaInteropApi::class)
fun Koin.get(objCProtocol: ObjCProtocol): Any {
    val kClazz = getOriginalKotlinClass(objCProtocol)!!
    return get(kClazz)
}

/**
 * Gets object of type which conforms to the [objCProtocol] with a String parameter [parameter]
 * Use when getting types that inherit/implement [objCProtocol]
 * Swift code example:
 *      let service: Service = Koin.instance.get(objCProtocol: Service.self, parameter: chatRoomId)
 */
@OptIn(BetaInteropApi::class)
fun Koin.get(objCProtocol: ObjCProtocol, parameter: String): Any {
    val kClazz = getOriginalKotlinClass(objCProtocol)!!
    return get(kClazz) { parametersOf(parameter) }
}