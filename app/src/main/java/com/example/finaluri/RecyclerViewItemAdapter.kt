package com.example.finaluri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



class RecyclerViewItemAdapter(private val itemList: List<Item>) :
    RecyclerView.Adapter<RecyclerViewItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var imageView: ImageView
        private lateinit var textView: TextView
        private lateinit var textView1: TextView


        init {
            imageView = itemView.findViewById(R.id.imageView)
            textView = itemView.findViewById(R.id.textTitle)
            textView1 = itemView.findViewById(R.id.textDescription)
        }

        fun setData(item: Item) {
            textView.text = item.title
            textView1.text = item.description

            Glide.with(itemView)
                .load(item.imageUrl)
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ItemViewHolder (itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setData(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}