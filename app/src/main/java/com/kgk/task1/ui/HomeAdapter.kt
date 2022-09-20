package com.kgk.task1.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kgk.task1.R
import com.kgk.task1.databinding.RowHomeBinding
import kotlinx.android.synthetic.main.row_home.view.*

class HomeAdapter(
    private val context: Context, private val dataList: List<HomeResponse>, private val page: Int,
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder(itemView: RowHomeBinding) : RecyclerView.ViewHolder(itemView.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.row_home, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.text.text = dataList[position].title
        Glide.with(context).load(dataList[position].url + ".png")
            .placeholder(R.mipmap.ic_launcher)
            .into(holder.itemView.img)
    }

    override fun getItemCount(): Int {
        return if (page * 200 > dataList.size) {
            dataList.size
        } else {
            page * 200
        }
    }
}