package id.kelompokpsi.travelin.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import id.kelompokpsi.travelin.R
import id.kelompokpsi.travelin.api.ApiClient
import id.kelompokpsi.travelin.model.wisata.DetailWisata
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    var id_wisata: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        title = "Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        id_wisata = intent.extras!!.getString("id_wisata", null)

        getData()

    }

    private fun getData() {

        ApiClient().services.getDetailWisata(id_wisata).enqueue(object :
            Callback<DetailWisata> {
            override fun onResponse(call: Call<DetailWisata>, response: Response<DetailWisata>) {
                //Tulis code jika response sukses
                if(response.code() == 200) {
//                    tv_lapangan.text = response.body()?.getName()
//                    tv_alamat.text = response.body()?.getAlamat()
//                    tv_notelp.text = response.body()?.getPhone()
//                    Glide.with(this@DetailActivity)
//                        .load(response.body()?.getGambar())
//                        .into(img_lapangan)

                }
            }
            override fun onFailure(call: Call<DetailWisata>, t: Throwable){
//                Toast.makeText(this@DetailActivity, "Belum ada data", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId)  {
            android.R.id.home -> finish()
//            R.id.action_favorite -> favorite(item)
        }

        return super.onOptionsItemSelected(item)
    }
}