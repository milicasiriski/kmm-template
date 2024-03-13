package com.example.kmmtemplate.android.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.kmmtemplate.data.local.KeyValueStore

class SharedPreferencesKeyValueStore(context: Context) : KeyValueStore {
    private val sharedPreferences: SharedPreferences

    init {
        sharedPreferences = context.getSharedPreferences("local-storage", Context.MODE_PRIVATE)
    }

    override fun read(key: String): String? = sharedPreferences.getString(key, null)

    override fun write(key: String, value: String) {
        sharedPreferences.edit {
            putString(key, value)
        }
    }

    override fun delete(key: String) {
        sharedPreferences.edit {
            remove(key)
        }
    }
}