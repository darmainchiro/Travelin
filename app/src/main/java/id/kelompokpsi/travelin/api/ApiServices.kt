package id.kelompokpsi.travelin.api

import id.kelompokpsi.travelin.model.auth.Login
import retrofit2.Call
import retrofit2.http.*
import java.util.*

interface ApiServices {
    @FormUrlEncoded
    @POST("login")
    fun postLogin(
        @FieldMap params: HashMap<String, String>?
    ): Call<Login>

}