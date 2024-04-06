package com.example.kmmtemplate.dependency_injection

import com.example.kmmtemplate.data.local.KeyValueLocalStorage
import com.example.kmmtemplate.data.local.LocalStorage
import com.example.kmmtemplate.item.domain.GetItemsUseCase
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

    val itemModule = module {
        factory { GetItemsUseCase() }
    }
}

fun initKoin(
    setContext: KoinApplication.() -> Unit = {},
    dataModule: Module = Modules.dataModule,
    loginModule: Module = Modules.loginModule,
    itemModule: Module = Modules.itemModule,
    platformSpecificModule: Module = module { },
    viewModelsModule: Module = module { }
): KoinApplication = startKoin {
    this.setContext()
    modules(
        dataModule,
        loginModule,
        itemModule,
        platformSpecificModule,
        viewModelsModule
    )
}