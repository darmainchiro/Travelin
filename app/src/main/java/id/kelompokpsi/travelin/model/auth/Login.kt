package id.kelompokpsi.travelin.model.auth

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Login {
    @SerializedName("success")
    @Expose
    var success: Boolean? = null

    @SerializedName("user")
    @Expose
    var user: Data_Login? = null

    @SerializedName("api_token")
    @Expose
    var apiToken: String? = null

}