package com.silikhe.healthcare.Data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "my_data_store")
//private val Context.dataStore by preferencesDataStore("my_data_store")

class UserPreferences(
    context: Context
) {
//    private val dataStore = context.dataStore
    private val applicationContext = context.applicationContext
//    private val dataStore: DataStore<Preferences>

    private val dataStore: DataStore<Preferences> = context.createDataStore(
        name = "my_data_store"
    )

//    init {
//        dataStore = applicationContext.createDataStore(
//            name = "my_data_store"
//        )
//
////        val Context.settingsDataStore: DataStore<Settings> by dataStore(
////            fileName = "settings.pb",
////        )
//    }

    val authToken: Flow<String?>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_AUTH]
        }

    suspend fun saveAuthToken(authToken: String) {
        dataStore.edit { preference ->
            preference[KEY_AUTH] = authToken
        }
    }

    companion object {
        private val KEY_AUTH = stringPreferencesKey("key_auth")
    }
}


