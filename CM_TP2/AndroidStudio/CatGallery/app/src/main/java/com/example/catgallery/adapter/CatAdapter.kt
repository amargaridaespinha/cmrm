package com.example.catgallery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.catgallery.R
import com.example.catgallery.model.CatImage

class CatAdapter(
    private val images: List<CatImage>
) : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    class CatViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cat, parent, false)

        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {

        Glide.with(holder.itemView.context)
            .load(images[position].url)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int = images.size
}