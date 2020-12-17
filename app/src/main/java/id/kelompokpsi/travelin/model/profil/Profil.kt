package id.kelompokpsi.travelin.model.profil

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Profil {
    @SerializedName("success")
    @Expose
    private var success: Boolean? = null

    @SerializedName("message")
    @Expose
    private var message: String? = null

    @SerializedName("user")
    @Expose
    private var user: Data_User? = null

    fun getSuccess(): Boolean? {
        return success
    }

    fun setSuccess(success: Boolean?) {
        this.success = success
    }

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String?) {
        this.message = message
    }

    fun getUser(): Data_User? {
        return user
    }

    fun setUser(user: Data_User?) {
        this.user = user
    }
}