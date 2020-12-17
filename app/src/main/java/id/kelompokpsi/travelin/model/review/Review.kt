package id.kelompokpsi.travelin.model.review

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Review {
    @SerializedName("wisata")
    @Expose
    private var wisata: Data_Review? = null

    @SerializedName("message")
    @Expose
    private var message: String? = null

    @SerializedName("success")
    @Expose
    private  var success:kotlin.Boolean? = null

}