package com.example.musicwiki.fragment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.musicwiki.fragment.AlbumFragment
import com.example.musicwiki.fragment.ArtistFragment
import com.example.musicwiki.fragment.TrackFragment

class ViewPagerAdapter(fragmentAdapter: FragmentManager, lifecycle: Lifecycle,tag:String):
    FragmentStateAdapter(fragmentAdapter,lifecycle){
    val genre = tag
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return  when(position){
            0-> AlbumFragment.newInstance(genre)

            1-> TrackFragment.newInstance(genre)

            2-> ArtistFragment.newInstance(genre)

            else -> {
                Fragment()
            }
        }
    }
}