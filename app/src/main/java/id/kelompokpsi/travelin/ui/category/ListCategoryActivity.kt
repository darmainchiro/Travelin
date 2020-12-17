package id.kelompokpsi.travelin.ui.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import id.kelompokpsi.travelin.R
import id.kelompokpsi.travelin.api.ApiClient
import id.kelompokpsi.travelin.model.wisata.Wisata
import id.kelompokpsi.travelin.ui.home.HomeAdapter
import kotlinx.android.synthetic.main.activity_list_category.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListCategoryActivity : AppCompatActivity() {

    var id_category: String? = null
    var category: String? = null

    private var list = ArrayList<Wisata>()
    private lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_category)

        id_category = intent.extras!!.getString("id_category", null)
        category = intent.extras!!.getString("category", null)

        title = "List " + category
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        getWisata()

    }

    private fun getWisata(){
        ApiClient().services.getCategoryWisata(id_category).enqueue(object :
            Callback<List<Wisata>> {
            override fun onResponse(call: Call<List<Wisata>>, response: Response<List<Wisata>>) {
                //Tulis code jika response sukses
                if(response.code() == 200) {
                    list = response.body() as ArrayList<Wisata>
                    rv_list_category.layoutManager = LinearLayoutManager(this@ListCategoryActivity)
                    listAdapter = ListAdapter(this@ListCategoryActivity, list)
                    rv_list_category.adapter = listAdapter
                    listAdapter.notifyDataSetChanged()
                }
            }
            override fun onFailure(call: Call<List<Wisata>>, t: Throwable){
                Toast.makeText(this@ListCategoryActivity, "Belum ada data", Toast.LENGTH_SHORT).show()
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