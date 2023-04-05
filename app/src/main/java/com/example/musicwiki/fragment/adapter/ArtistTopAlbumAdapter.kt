package com.example.musicwiki.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.R
import com.example.musicwiki.api.topartiestresponse.artisttopalbum.Album
import com.example.musicwiki.api.topartiestresponse.toptrackresponse.Track
import com.example.musicwiki.databinding.TrackLayoutBinding
import com.example.musicwiki.utils.loadimage

class ArtistTopAlbumAdapter: ListAdapter<Album, ArtistTopAlbumAdapter.ViewHolder>(object : DiffUtil.ItemCallback<Album>(){
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
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
        holder.binding.imageView3.setImageResource(R.drawable.track)
    }

}