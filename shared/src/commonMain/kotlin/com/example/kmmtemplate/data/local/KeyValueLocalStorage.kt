package com.example.kmmtemplate.data.local

class KeyValueLocalStorage(private val store: KeyValueStore) : LocalStorage {
    override fun saveUser(user: String) {
        store.write(userKey, user)
    }

    // Kotlin allows us to shorten functions
    // The equivalent long version would be:
    // override fun getUser(): String? {
    //     return store.read(userKey)
    // }
    override fun getUser() = store.read(userKey)

    override fun clear() {
        store.delete(userKey)
        // Delete other entries ...
    }

    companion object {
        private const val userKey = "user"
    }
}