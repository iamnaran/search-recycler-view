package com.template.androidtemplate.ui.main.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.template.androidtemplate.R
import com.template.androidtemplate.data.model.Home
import kotlinx.android.synthetic.main.item_category_row.view.*

class CategoryAdapter(private val categoriesList: ArrayList<Home.Categories>) : RecyclerView.Adapter<CategoryAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(category: Home.Categories) {
            itemView.categoryName.text = category.name
            Glide.with(itemView.categoryCover.context)
                .load(category.image)
                .into(itemView.categoryCover)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  DataViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_category_row, parent,
            false
        )
    )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(categoriesList[position])
    }

    override fun getItemCount(): Int = categoriesList.size

    fun addData(list: List<Home.Categories>) {
        categoriesList.addAll(list)
    }

}