package com.example.todolivedatapractice.view.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolivedatapractice.databinding.ShowDetailItemBinding
import com.example.todolivedatapractice.model.Blog

class BlogAdpter( val context: Context, val blokList: List<Blog>) : RecyclerView.Adapter<BlogAdpter.BlogHolder>() {
    class BlogHolder(val binding: ShowDetailItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogHolder {
        return   BlogHolder(
            ShowDetailItemBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return blokList.size
    }

    override fun onBindViewHolder(holder: BlogHolder, position: Int) {
       holder.binding.showName.text=blokList[position].name
       holder.binding.showTitle.text= blokList[position].title
       holder.binding.showSubTitle.text=blokList[position].description


    }
}






