package id.kelompokpsi.travelin.model.review

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data_Review {
    @SerializedName("created_at")
    @Expose
    private val createdAt: String? = null

    @SerializedName("id")
    @Expose
    private val id: Int? = null

    @SerializedName("id_wisata")
    @Expose
    private val idWisata: String? = null

    @SerializedName("id_user")
    @Expose
    private val idUser: String? = null

    @SerializedName("rating")
    @Expose
    private val rating: String? = null

    @SerializedName("review")
    @Expose
    private val review: String? = null

    @SerializedName("updated_at")
    @Expose
    private val updatedAt: String? = null
}