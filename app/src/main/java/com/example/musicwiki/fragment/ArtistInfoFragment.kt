package com.example.musicwiki.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.musicwiki.R
import com.example.musicwiki.api.services.BaseResponse
import com.example.musicwiki.databinding.FragmentArtistInfoBinding
import com.example.musicwiki.fragment.adapter.ArtistTopAlbumAdapter
import com.example.musicwiki.fragment.adapter.ArtistTopTrackAdapter
import com.example.musicwiki.fragment.adapter.TrackAdapter
import com.example.musicwiki.utils.loadimage
import com.example.musicwiki.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistInfoFragment : Fragment() {
    private lateinit var binding:FragmentArtistInfoBinding
    private val viewModel:MainViewModel by viewModels()
    private var artistName =""
    private lateinit var trackAdapter:ArtistTopTrackAdapter
    private lateinit var albumAdapter:ArtistTopAlbumAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString("NAME")?.let {
            artistName = it
        }
        viewModel.getArtistInfo(artistName)
        viewModel.getArtistTopAlbum(artistName)
        viewModel.getArtistTrack(artistName)
        trackAdapter = ArtistTopTrackAdapter()
        albumAdapter = ArtistTopAlbumAdapter()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentArtistInfoBinding.inflate(layoutInflater)
        observeViewModel()
        return binding.root
    }

    private fun observeViewModel(){
        viewModel.getArtistInfoLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is BaseResponse.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is BaseResponse.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.title.text = it.data?.artist?.name
                    binding.disc.text = it.data?.artist?.bio?.summary
                    it.data?.artist?.image?.get(3)?.text?.let { it1 -> binding.banner.loadimage(it1) }
                }
                is BaseResponse.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), it.msg, Toast.LENGTH_LONG).show()
                }
                else->{binding.progressBar.visibility = View.GONE}
            }
        }
        viewModel.getArtistTopAlbumLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is BaseResponse.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is BaseResponse.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.AlbumRv.adapter  = albumAdapter
                    albumAdapter.submitList(it.data?.topalbums?.album)
                }
                is BaseResponse.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), it.msg, Toast.LENGTH_LONG).show()
                }
                else->{binding.progressBar.visibility = View.GONE}
            }
        }

        viewModel.getArtistTrackLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is BaseResponse.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is BaseResponse.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.trackEv.adapter  = trackAdapter

                    trackAdapter.submitList(it.data?.toptracks?.track)
                }
                is BaseResponse.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), it.msg, Toast.LENGTH_LONG).show()
                }
                else->{binding.progressBar.visibility = View.GONE}
            }
        }

    }

}