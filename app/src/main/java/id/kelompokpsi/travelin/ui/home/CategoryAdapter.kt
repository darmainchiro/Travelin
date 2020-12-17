package id.kelompokpsi.travelin.ui.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.kelompokpsi.travelin.R
import id.kelompokpsi.travelin.model.category.Category
import id.kelompokpsi.travelin.model.wisata.Wisata
import id.kelompokpsi.travelin.ui.category.ListCategoryActivity
import id.kelompokpsi.travelin.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.item_most_view.view.*
import kotlinx.android.synthetic.main.item_wisata.view.*
import java.util.ArrayList

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.ListViewHolder>{
//    var movieList : List<Movie> = listOf()

    var act: Context? = null
    var categoryItem: List<Category>? = null

    constructor(recyclerViewActivity: Context, categoryList: List<Category>) {
        act = recyclerViewActivity
        categoryItem = categoryList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_most_view, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = categoryItem?.size!!

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        categoryItem?.get(position)?.let { holder.bind(it) }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(category: Category) {
            with(itemView){

                title.text = category.getCategory()
                act?.let {
                    Glide.with(it)
                        .load(category.getGambar())
                        .into(image)
                }
                itemView.setOnClickListener {
                    val intent = Intent(act, ListCategoryActivity::class.java)
                    intent.putExtra("id_category", category.getId().toString())
                    intent.putExtra("name_category", category.getCategory().toString())
                    act?.startActivity(intent)
                }
            }
        }
    }

}