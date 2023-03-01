package com.example.examenfinalpruebaandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UrlAdapter
    (
    val urlList: List<UrlEntity>,
    val clickListener: (UrlEntity) -> Unit,
    val deleteUrl:(UrlEntity) -> Unit
) : RecyclerView.Adapter<UrlAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_url, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return urlList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(urlList[position], clickListener, deleteUrl)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvUrl = view.findViewById<TextView>(R.id.tvUrl)

        fun bind(url: UrlEntity, clickListener: (UrlEntity) -> Unit, deleteUrl: (UrlEntity) -> Unit) {
            tvUrl.text = url.name
            itemView.setOnClickListener { clickListener(url) }
            itemView.setOnLongClickListener { deleteUrl(url); true }

        }
    }
}