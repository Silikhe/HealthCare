package com.silikhe.healthcare.Data

import android.content.Context
import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey

import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "my_data_store")
//private val Context.dataStore by preferencesDataStore("my_data_store")


class UserPreferences(
    context: Context
) {
    private val applicationContext = context.applicationContext

    private val dataStore: DataStore<Preferences>

    init {
        dataStore = applicationContext.createDataStore(
            name = "my_data_store"
        )

    }

    val authToken: Flow<String?>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_AUTH]
        }

    suspend fun saveAuthToken(authToken: String) {
        val sharedPreferences: SharedPreferences =
            applicationContext.getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.apply {
            putString("auth_key", authToken)
        }.apply()
//        dataStore.edit { preference ->
//            preference[KEY_AUTH] = authToken
//        }
    }

    fun loadData() {
        val sharedPreferences: SharedPreferences =
            applicationContext.getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
        val savedString: String? = sharedPreferences.getString("auth_key", null)
    }

    companion object {
        private val KEY_AUTH = preferencesKey<String>("key_auth")
    }


}


