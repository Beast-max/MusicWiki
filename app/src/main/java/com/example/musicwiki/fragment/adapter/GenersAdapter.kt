package com.example.musicwiki.fragment.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.api.genresresponse.Tag
import com.example.musicwiki.databinding.GenresLayoutBinding

class GenersAdapter(val listner:OnClick):ListAdapter<Tag,GenersAdapter.ViewHolder>(object :DiffUtil.ItemCallback<Tag>(){
    override fun areItemsTheSame(oldItem: Tag, newItem: Tag): Boolean {
        return oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: Tag, newItem: Tag): Boolean {
        return oldItem==newItem
    }

}) {
    inner class ViewHolder( val binding:GenresLayoutBinding):RecyclerView.ViewHolder(binding.root)
     var list_type:Boolean = false
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = GenresLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.textView2.text = item.name
        holder.binding.root.setOnClickListener {
            listner.onClick(item.name)
        }
    }

    override fun getItemCount(): Int {
        return if(!list_type){
            Log.d("list_type","true")
            10
        } else{
            Log.d("list_type","false")
            super.getItemCount()
        }
    }
    interface OnClick{
        fun onClick(genre:String)
    }
}