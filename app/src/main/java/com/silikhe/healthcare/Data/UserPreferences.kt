package com.silikhe.healthcare.Data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences

private val Context.dataStore by preferencesDataStore("my_data_store")

//class UserPreferences(
//    context: Context
//) {
//    //    private val dataStore = context.dataStore
//    private val applicationContext = context.applicationContext
//    private val dataStore: DataStore<Preferences>
//
//    init {
//        dataStore = applicationContext.createDataStore(
//            name = "my_data_store"
//        )
//    }
//
//    val authToken: Flow<String>
//        get() = dataStore.data.map {
//            preferences[KEY_AUTH]
//        }
//
//    suspend fun saveAuthToken(authToken: String) {
//        dataStore.edit { preference ->
//            KEY_AUTH = authToken
//        }
//    }
//
//    companion object {
//        private val KEY_AUTH = preferencesKey<String>("auth_key")
//    }
//}


