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
import com.example.musicwiki.databinding.FragmentAlbumInfoBinding
import com.example.musicwiki.fragment.adapter.TrackListAdapter
import com.example.musicwiki.utils.loadimage
import com.example.musicwiki.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumInfoFragment : Fragment() {
    private var name: String = ""
    private var artistName:String = ""
    private val viewModel:MainViewModel by viewModels()
    private lateinit var binding:FragmentAlbumInfoBinding
    private lateinit var adapter:TrackListAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString("album_name")?.let {
            name = it
        }
        arguments?.getString("artist_name")?.let {
            artistName = it
        }
        adapter = TrackListAdapter()
        viewModel.getAlbumInfo(name,artistName)


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumInfoBinding.inflate(layoutInflater)
        observeViewModel()
        return binding.root
    }
    private fun observeViewModel(){
        viewModel.getAlbumInfoLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is BaseResponse.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is BaseResponse.Success -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.album?.image?.get(3)?.let { it1 -> it1.text?.let { it2 ->
                        binding.banner.loadimage(
                            it2
                        )
                    } }
                   binding.title.text = it.data?.album?.name
                    binding.disc.text = it.data?.album?.wiki?.summary
                    binding.trackEv.adapter = adapter
                    adapter.submitList(it.data?.album?.tracks?.track)

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