package com.example.kmmtemplate.android

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import com.example.kmmtemplate.android.navigation.Navigation
import com.example.kmmtemplate.android.util.PermissionsProvider

class MainActivity : ComponentActivity(), PermissionsProvider {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(
                        navController = navController,
                        // short for this::finish - passing a method as a parameter
                        finish = ::finish,
                        // which can be written as
//                        finish = { this.finish() },
                        permissionsProvider = this
                    )
                }
            }
        }
    }

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                println("Requested permission is granted")
            } else {
                println("Requested permission is denied")
            }
        }

    override fun requestPermission(permission: String) {
        println("Requesting permission: $permission")
        when {
            ContextCompat.checkSelfPermission(this, permission) ==
                    PackageManager.PERMISSION_GRANTED -> {
                println("$permission granted")
            }

            ActivityCompat.shouldShowRequestPermissionRationale(this, permission) -> {
                println("Show $permission dialog")
            }

            else -> {
                requestPermissionLauncher.launch(permission)
            }
        }
    }

    override fun openSettings() {
        Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.parse("package:${this.packageName}")
        ).apply {
            addCategory(Intent.CATEGORY_DEFAULT)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
        }
    }
}