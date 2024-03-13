package com.example.kmmtemplate.dependency_injection

import com.example.kmmtemplate.data.local.KeyValueLocalStorage
import com.example.kmmtemplate.data.local.LocalStorage
import com.example.kmmtemplate.login.data.MockAccountService
import com.example.kmmtemplate.login.domain.AccountService
import com.example.kmmtemplate.login.domain.LoginUseCase
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

object Modules {
    val dataModule = module {
//        single { KtorClient() }
        single<LocalStorage> { KeyValueLocalStorage(get()) }
    }
    val loginModule = module {
        single<AccountService> { MockAccountService() }
//        single<AccountService> { HttpAccountService(get()) }
        factory { LoginUseCase(get(), get()) }
    }
}

fun initKoin(
    setContext: KoinApplication.() -> Unit = {},
    dataModule: Module = Modules.dataModule,
    loginModule: Module = Modules.loginModule,
    platformSpecificModule: Module = module { },
    viewModelsModule: Module = module { }
): KoinApplication = startKoin {
    this.setContext()
    modules(
        dataModule,
        loginModule,
        platformSpecificModule,
        viewModelsModule
    )
}