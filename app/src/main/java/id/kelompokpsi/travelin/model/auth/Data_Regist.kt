package id.kelompokpsi.travelin.model.auth

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data_Regist {
    @SerializedName("id_user")
    @Expose
    var idUser: String? = null

    @SerializedName("username")
    @Expose
    var username: String? = null

    @SerializedName("phone")
    @Expose
    var phone: String? = null

    @SerializedName("status")
    @Expose
    var status: String? = null

}