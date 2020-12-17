package id.kelompokpsi.travelin.ui.home

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.google.android.material.internal.ViewUtils.dpToPx
import id.kelompokpsi.travelin.R
import id.kelompokpsi.travelin.api.ApiClient
import id.kelompokpsi.travelin.model.category.Category
import id.kelompokpsi.travelin.model.wisata.Wisata
import id.kelompokpsi.travelin.ui.category.ListCategoryActivity
import id.kelompokpsi.travelin.utils.GridSpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    private lateinit var homeAdapter: HomeAdapter
    private var list = ArrayList<Wisata>()

    private lateinit var categoryAdapter: CategoryAdapter
    private var list_category = ArrayList<Category>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        root.btn_all.setOnClickListener {
            val intent = Intent(activity, ListCategoryActivity::class.java)
            intent.putExtra("id_category", "0")
            intent.putExtra("category", "Semua")
            activity?.startActivity(intent)
        }

        root.btn_museum.setOnClickListener {
            val intent = Intent(activity, ListCategoryActivity::class.java)
            intent.putExtra("id_category", "2")
            intent.putExtra("category", "Museum")
            activity?.startActivity(intent)
        }

        root.btn_mount.setOnClickListener {
            val intent = Intent(activity, ListCategoryActivity::class.java)
            intent.putExtra("id_category", "4")
            intent.putExtra("category", "Pegunungan")
            activity?.startActivity(intent)
        }

        root.btn_beach.setOnClickListener {
            val intent = Intent(activity, ListCategoryActivity::class.java)
            intent.putExtra("id_category", "3")
            intent.putExtra("category", "Pantai")
            activity?.startActivity(intent)
        }

        root.btn_hotel.setOnClickListener {
            val intent = Intent(activity, ListCategoryActivity::class.java)
            intent.putExtra("id_category", "5")
            intent.putExtra("category", "Hotel")
            activity?.startActivity(intent)
        }

        val layoutManagerfn: RecyclerView.LayoutManager =
            LinearLayoutManager(activity)
        root.rv_most.setLayoutManager(layoutManagerfn)
        (layoutManagerfn as LinearLayoutManager).orientation =
            LinearLayoutManager.HORIZONTAL
        root.rv_most.addItemDecoration(
            GridSpacingItemDecoration(
                10, dpToPx(10),
                true
            )
        )
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(root.rv_most)

        getWisata()
        getCategory()

        return root
    }

    private fun getCategory(){
        ApiClient().services.getCategory().enqueue(object :
            Callback<List<Category>> {
            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                //Tulis code jika response sukses
                if(response.code() == 200) {
                    list_category = response.body() as ArrayList<Category>
                    categoryAdapter = activity?.let { CategoryAdapter(it,list_category) }!!
                    rv_most.adapter = categoryAdapter

                }
            }
            override fun onFailure(call: Call<List<Category>>, t: Throwable){
                Toast.makeText(activity, "Belum ada data", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getWisata(){
        ApiClient().services.getWisata().enqueue(object :
            Callback<List<Wisata>> {
            override fun onResponse(call: Call<List<Wisata>>, response: Response<List<Wisata>>) {
                //Tulis code jika response sukses
                if(response.code() == 200) {
                    list = response.body() as ArrayList<Wisata>
                    rv_wisata.layoutManager = LinearLayoutManager(activity)
                    homeAdapter = activity?.let { HomeAdapter(it,list) }!!
                    rv_wisata.adapter = homeAdapter
                    homeAdapter.notifyDataSetChanged()
                }
            }
            override fun onFailure(call: Call<List<Wisata>>, t: Throwable){
                Toast.makeText(activity, "Belum ada data", Toast.LENGTH_SHORT).show()
            }
        })
    }

    /**
     * Converting dp to pixel
     */
    private fun dpToPx(dp: Int): Int {
        val r: Resources = resources
        return Math.round(
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp.toFloat(),
                r.getDisplayMetrics()
            )
        )
    }

}