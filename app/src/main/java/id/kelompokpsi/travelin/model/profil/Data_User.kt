package id.kelompokpsi.travelin.model.profil

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Data_User {
    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null

    @SerializedName("username")
    @Expose
    private var username: String? = null

    @SerializedName("role_id")
    @Expose
    private var roleId: Int? = null

    @SerializedName("email")
    @Expose
    private var email: String? = null

    @SerializedName("email_verified_at")
    @Expose
    private var emailVerifiedAt: String? = null

    @SerializedName("api_token")
    @Expose
    private var apiToken: String? = null

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

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getUsername(): String? {
        return username
    }

    fun setUsername(username: String?) {
        this.username = username
    }

    fun getRoleId(): Int? {
        return roleId
    }

    fun setRoleId(roleId: Int?) {
        this.roleId = roleId
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String?) {
        this.email = email
    }

    fun getEmailVerifiedAt(): String? {
        return emailVerifiedAt
    }

    fun setEmailVerifiedAt(emailVerifiedAt: String?) {
        this.emailVerifiedAt = emailVerifiedAt
    }

    fun getApiToken(): String? {
        return apiToken
    }

    fun setApiToken(apiToken: String?) {
        this.apiToken = apiToken
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