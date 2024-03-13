package com.example.kmmtemplate.android

import android.app.Application
import com.example.kmmtemplate.android.data.SharedPreferencesKeyValueStore
import com.example.kmmtemplate.android.home.HomeViewModel
import com.example.kmmtemplate.android.login.LoginViewModel
import com.example.kmmtemplate.data.local.KeyValueStore
import com.example.kmmtemplate.dependency_injection.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class KmmTemplateApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin(
            setContext = { androidContext(this@KmmTemplateApplication) },
            platformSpecificModule = module {
                single<KeyValueStore> { SharedPreferencesKeyValueStore(get()) }
            },
            viewModelsModule = module {
                viewModel {
                    LoginViewModel(get())
                }
                viewModel {
                    HomeViewModel(get())
                }
            }
        )
    }
}