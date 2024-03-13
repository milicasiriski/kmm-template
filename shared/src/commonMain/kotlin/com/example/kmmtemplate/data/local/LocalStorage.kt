package com.example.kmmtemplate.data.local

interface LocalStorage {
    fun saveUser(user: String)
    fun getUser(): String?
    /**
     * Clears all locally stored data
     */
    fun clear()
}