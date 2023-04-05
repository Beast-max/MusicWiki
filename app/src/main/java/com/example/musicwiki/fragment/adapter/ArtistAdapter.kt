package com.example.musicwiki.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.api.topartiestresponse.Artist
import com.example.musicwiki.api.trackresponse.Track
import com.example.musicwiki.databinding.RvItemBinding
import com.example.musicwiki.utils.loadimage

class ArtistAdapter(val listner:OnClick) : ListAdapter<Artist, ArtistAdapter.ViewHolder>(object : DiffUtil.ItemCallback<Artist>(){
    override fun areItemsTheSame(oldItem: Artist, newItem: Artist): Boolean {
        return oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: Artist, newItem: Artist): Boolean {
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
        holder.binding.root.setOnClickListener {
            listner.onCLick(item.name)
        }
        holder.binding.textView2.text = item.name
        holder.binding.circleImageView.loadimage(item.image[3].text)
    }
    interface OnClick{
        fun onCLick(name:String)
    }

}