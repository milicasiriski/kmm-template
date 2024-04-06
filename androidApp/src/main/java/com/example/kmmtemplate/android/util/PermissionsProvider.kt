package com.example.kmmtemplate.android.util

interface PermissionsProvider {
    fun requestPermission(permission: String)
    fun openSettings()
}