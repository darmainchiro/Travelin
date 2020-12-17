package id.kelompokpsi.travelin.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.kelompokpsi.travelin.MainActivity
import id.kelompokpsi.travelin.R
import id.kelompokpsi.travelin.api.ApiClient
import id.kelompokpsi.travelin.model.auth.Login
import kotlinx.android.synthetic.main.login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class LoginActivity : AppCompatActivity() {

    var session: Session? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        session = Session(this)

        if (session?.login()!!) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        btn_login.setOnClickListener {
            postLogin()
        }
    }

    private fun postLogin() {
        loading.visibility = View.VISIBLE
        val email = et_email.text.toString().trim()
        val password = et_password.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(
                this@LoginActivity,
                "Mohon lengkapi username atau password !",
                Toast.LENGTH_SHORT
            ).show()
        } else if (et_email.getText().toString().contains(" ")) {
            et_email.setError("Tidak Boleh Spasi")
            Toast.makeText(this@LoginActivity, "Tidak Boleh Spasi", Toast.LENGTH_SHORT).show()
        } else {
            val params = HashMap<String, String>()
            params.put("email", email);
            params.put("password", password)
            ApiClient().services.postLogin(params)?.enqueue(object :
                Callback<Login> {
                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    if (response.code() == 201) {
                        loading.visibility = View.GONE
                        val token = response.body()?.user?.getApiToken()
                        session!!.setLogin(
                            true,
                            response.body()?.user?.getId().toString(),
                            response.body()?.user?.getEmail().toString(),
                            response.body()?.user?.getUsername().toString(),
                            response.body()?.user?.getName().toString(),
                            response.body()?.user?.getApiToken().toString(),
                            response.body()?.user?.getRoleId().toString()
                        )
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                        finish()

                    }
                }

                override fun onFailure(call: Call<Login>, t: Throwable) {
                    loading.visibility = View.GONE
                }
            })
        }
    }
}