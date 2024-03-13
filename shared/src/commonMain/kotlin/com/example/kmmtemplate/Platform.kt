package com.example.kmmtemplate

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform