package com.template.androidtemplate.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.template.androidtemplate.R
import com.template.androidtemplate.data.model.Home
import kotlinx.android.synthetic.main.item_category_row.view.*

class CategoryRecyclerViewAdapter(
    private val categories: ArrayList<Home.Categories>
) : RecyclerView.Adapter<CategoryRecyclerViewAdapter.DataViewHolder>() {


    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(category: Home.Categories) {
            itemView.categoryName.text = category.name
            Glide.with(itemView.categoryCover.context)
                .load(category.image)
                .into(itemView.categoryCover)
        }
    }



    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        holder.bind(categories[position])
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_category_row, parent,
                false
            )
        )

    override fun getItemCount(): Int = categories.size


    fun addData(list: List<Home.Categories>) {
        categories.addAll(list)
    }


}