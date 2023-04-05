package com.example.musicwiki.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.api.trackresponse.Track
import com.example.musicwiki.databinding.RvItemBinding
import com.example.musicwiki.utils.loadimage

class TrackAdapter : ListAdapter<Track, TrackAdapter.ViewHolder>(object : DiffUtil.ItemCallback<Track>(){
    override fun areItemsTheSame(oldItem: Track, newItem: Track): Boolean {
        return oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: Track, newItem: Track): Boolean {
        return oldItem==newItem
    }

}) {
    inner class ViewHolder( val binding: RvItemBinding): RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.textView2.text = item.name
        holder.binding.circleImageView.loadimage(item.image[3].text)
    }

}