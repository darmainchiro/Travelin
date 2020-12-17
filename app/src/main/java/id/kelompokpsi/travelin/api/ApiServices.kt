package id.kelompokpsi.travelin.api

import id.kelompokpsi.travelin.model.auth.Login
import id.kelompokpsi.travelin.model.auth.Register
import id.kelompokpsi.travelin.model.category.Category
import id.kelompokpsi.travelin.model.profil.Profil
import id.kelompokpsi.travelin.model.review.Review
import id.kelompokpsi.travelin.model.wisata.DetailWisata
import id.kelompokpsi.travelin.model.wisata.Wisata
import retrofit2.Call
import retrofit2.http.*
import java.util.*

interface ApiServices {
    @FormUrlEncoded
    @POST("login")
    fun postLogin(
        @FieldMap params: HashMap<String, String>?
    ): Call<Login>
  
    @FormUrlEncoded
    @POST("add-review")
    fun postReview(
        @FieldMap params: HashMap<String, String>?
    ): Call<Review>

    @GET("user/{id}")
    fun getUser(
        @Path("id") id: String?,
        @Header("Authorization") authorization: String?
    ): Call<Profil>

    //Category
    @GET("category")
    fun getCategory(): Call<List<Category>>

    @FormUrlEncoded
    @POST("user/editUser.php")
    fun updateUser(
        @FieldMap params: HashMap<String?, String?>?
    ): Call<Register?>?

    //Wisata
    @GET("travels")
    fun getWisata(
    ): Call<List<Wisata>>

    @GET("travel/category/{id_category}")
    fun getCategoryWisata(
        @Path("id_category") id_categoryd: String?
    ): Call<List<Wisata>>


    @GET("travel/{id}")
    fun getDetailWisata(
        @Path("id") id: String?
    ): Call<DetailWisata>

}