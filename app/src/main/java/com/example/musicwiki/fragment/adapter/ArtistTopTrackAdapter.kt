package com.example.musicwiki.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.R
import com.example.musicwiki.api.topartiestresponse.toptrackresponse.Track
import com.example.musicwiki.databinding.TrackLayoutBinding
import com.example.musicwiki.utils.loadimage

class ArtistTopTrackAdapter: ListAdapter<Track, ArtistTopTrackAdapter.ViewHolder>(object : DiffUtil.ItemCallback<Track>(){
    override fun areItemsTheSame(oldItem: Track, newItem: Track): Boolean {
        return oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: Track, newItem: Track): Boolean {
        return oldItem==newItem
    }

}) {
    inner class ViewHolder( val binding: TrackLayoutBinding): RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = TrackLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.textView8.text = item.name
        holder.binding.imageView3.loadimage(item.image[3].text)
    }

}