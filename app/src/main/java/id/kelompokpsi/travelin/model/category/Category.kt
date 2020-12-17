package id.kelompokpsi.travelin.model.category

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Category {
    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("category")
    @Expose
    private var category: String? = null

    @SerializedName("gambar")
    @Expose
    private var gambar: String? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getCategory(): String? {
        return category
    }

    fun setCategory(category: String?) {
        this.category = category
    }

    fun getGambar(): String? {
        return gambar
    }

    fun setGambar(gambar: String?) {
        this.gambar = gambar
    }
}