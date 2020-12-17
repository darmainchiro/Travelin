package id.kelompokpsi.travelin.ui.category

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.kelompokpsi.travelin.R
import id.kelompokpsi.travelin.model.wisata.Wisata
import id.kelompokpsi.travelin.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.item_wisata.view.*
import java.util.ArrayList

class ListAdapter : RecyclerView.Adapter<ListAdapter.ListViewHolder>{
//    var movieList : List<Movie> = listOf()

    var act: Context? = null
    var wisataItem: List<Wisata>? = null

    constructor(recyclerViewActivity: Context, wisataList: List<Wisata>) {
        act = recyclerViewActivity
        wisataItem = wisataList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_wisata, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = wisataItem?.size!!

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        wisataItem?.get(position)?.let { holder.bind(it) }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(wisata: Wisata) {
            with(itemView){

                tvTitle.text = wisata.getNameWisata()
                tvAlamat.text = wisata.getAlamat()
                act?.let {
                    Glide.with(it)
                        .load(wisata.getGambar())
                        .into(ivThumb)
                }
                itemView.setOnClickListener {
//                    Toast.makeText(act, "ide "+order.getIdLapangan(), Toast.LENGTH_SHORT).show()
                    val intent = Intent(act, DetailActivity::class.java)
                    intent.putExtra("id_wisata", wisata.getId().toString())
                    act?.startActivity(intent)
                }
            }
        }
    }

}