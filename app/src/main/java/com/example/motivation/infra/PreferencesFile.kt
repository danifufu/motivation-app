package com.example.motivation.infra

import android.content.Context
import android.content.SharedPreferences

class PreferencesFile(context: Context) { // fazer a importacao do Context

    // instanciando o shared preferences
    private val preferences: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    // metodo para salvar o valor
    fun storeString(key: String, str: String) {
        preferences.edit().putString(key, str).apply()
    }

    // metodo para recuperar o valor que foi salvo
    fun getString(key: String): String {
        return preferences.getString(key, "") ?: "" // operador Elvis
    }
}
