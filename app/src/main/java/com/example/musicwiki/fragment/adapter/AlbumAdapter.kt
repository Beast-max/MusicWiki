package com.example.musicwiki.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.api.albumresponse.Album
import com.example.musicwiki.api.genresresponse.Tag
import com.example.musicwiki.databinding.RvItemBinding
import com.example.musicwiki.utils.loadimage

class AlbumAdapter(val listner:OnClick): ListAdapter<Album, AlbumAdapter.ViewHolder>(object : DiffUtil.ItemCallback<Album>(){
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
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
        holder.binding.root.setOnClickListener {
            listner.onClick(item.name,item.artist.name)
        }
        holder.binding.circleImageView.loadimage(item.image[3].text)
    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }
    interface OnClick{
        fun onClick(albumName:String,artistName:String)
    }
}