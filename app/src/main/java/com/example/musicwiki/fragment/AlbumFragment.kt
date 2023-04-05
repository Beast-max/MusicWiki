package com.example.musicwiki.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.musicwiki.R
import com.example.musicwiki.api.services.BaseResponse
import com.example.musicwiki.databinding.FragmentAlbumBinding
import com.example.musicwiki.fragment.adapter.AlbumAdapter
import com.example.musicwiki.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AlbumFragment(): Fragment(),AlbumAdapter.OnClick {
    private var genre: String = ""
    private lateinit var adapter:AlbumAdapter
    private val viewModel:MainViewModel by viewModels()
    private lateinit var binding:FragmentAlbumBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString("TAG")?.let {
            genre = it
        }
        adapter = AlbumAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding  = FragmentAlbumBinding.inflate(layoutInflater)
        viewModel.getAlbum(genre)
        observeViewModel()
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            AlbumFragment().apply {
                arguments = Bundle().apply {
                    putString("TAG", param1)
                }
            }
    }

    private fun observeViewModel(){
        viewModel.getAlbumLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is BaseResponse.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is BaseResponse.Success -> {
                    binding.progressBar.visibility = View.GONE
                    val controller =
                        AnimationUtils.loadLayoutAnimation(requireContext(), R.anim.dropanimatiolayout)
                    binding.albumRecyclerview.layoutAnimation = controller
                    binding.albumRecyclerview.scheduleLayoutAnimation()
                    binding.albumRecyclerview.adapter = adapter
                    adapter.submitList(it.data?.albums?.album)

                }
                is BaseResponse.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), it.msg, Toast.LENGTH_LONG).show()
                }
                else->{binding.progressBar.visibility = View.GONE}
            }
        }
    }

    override fun onClick(albumName: String, artistName: String) {
        val bundle = Bundle()
        bundle.putString("album_name",albumName)
        bundle.putString("artist_name",artistName)
        findNavController().navigate(R.id.action_genreInfoFragment_to_albumInfoFragment,bundle)
    }


}