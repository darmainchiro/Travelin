package id.kelompokpsi.travelin.model.auth

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Register {
    @SerializedName("error")
    @Expose
    var error: Boolean? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("data")
    @Expose
    var data: Data_Regist? = null

}