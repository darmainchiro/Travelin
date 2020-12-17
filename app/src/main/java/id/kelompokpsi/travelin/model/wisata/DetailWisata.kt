package id.kelompokpsi.travelin.model.wisata

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DetailWisata {
    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("id_category")
    @Expose
    private var idCategory: Int? = null

    @SerializedName("name_wisata")
    @Expose
    private var nameWisata: String? = null

    @SerializedName("description")
    @Expose
    private var description: String? = null

    @SerializedName("alamat")
    @Expose
    private var alamat: String? = null

    @SerializedName("fasilitas")
    @Expose
    private var fasilitas: String? = null

    @SerializedName("gambar")
    @Expose
    private var gambar: String? = null

    @SerializedName("created_at")
    @Expose
    private var createdAt: String? = null

    @SerializedName("updated_at")
    @Expose
    private var updatedAt: String? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getIdCategory(): Int? {
        return idCategory
    }

    fun setIdCategory(idCategory: Int?) {
        this.idCategory = idCategory
    }

    fun getNameWisata(): String? {
        return nameWisata
    }

    fun setNameWisata(nameWisata: String?) {
        this.nameWisata = nameWisata
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String?) {
        this.description = description
    }

    fun getAlamat(): String? {
        return alamat
    }

    fun setAlamat(alamat: String?) {
        this.alamat = alamat
    }

    fun getFasilitas(): String? {
        return fasilitas
    }

    fun setFasilitas(fasilitas: String?) {
        this.fasilitas = fasilitas
    }

    fun getGambar(): String? {
        return gambar
    }

    fun setGambar(gambar: String?) {
        this.gambar = gambar
    }

    fun getCreatedAt(): String? {
        return createdAt
    }

    fun setCreatedAt(createdAt: String?) {
        this.createdAt = createdAt
    }

    fun getUpdatedAt(): String? {
        return updatedAt
    }

    fun setUpdatedAt(updatedAt: String?) {
        this.updatedAt = updatedAt
    }
}