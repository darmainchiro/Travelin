package id.kelompokpsi.travelin.ui.auth

import android.content.Context
import android.content.SharedPreferences

class Session(var context: Context) {
    var prefs: SharedPreferences
    var editor: SharedPreferences.Editor
    fun setLogin(
        login: Boolean,
        id: String,
        email: String,
        username: String,
        name: String,
        token: String,
        role: String
    ) {
        editor.putBoolean("login", login)
        editor.putString("id", id)
        editor.putString("email", email)
        editor.putString("username", username)
        editor.putString("name", name)
        editor.putString("token", token)
        editor.putString("role", role)
        editor.commit()
    }

    fun login(): Boolean {
        return prefs.getBoolean("login", false)
    }

    fun role(): String? {
        return prefs.getString("role", "0")
    }

    init {
        prefs = context.getSharedPreferences("happy", Context.MODE_PRIVATE)
        editor = prefs.edit()
    }
}