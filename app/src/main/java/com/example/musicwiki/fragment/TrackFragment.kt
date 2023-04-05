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
import com.example.musicwiki.databinding.FragmentTrackBinding
import com.example.musicwiki.fragment.adapter.TrackAdapter
import com.example.musicwiki.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrackFragment : Fragment() {
    private var genre: String = ""
    private lateinit var adapter:TrackAdapter
    private lateinit var binding:FragmentTrackBinding
    private val viewModel :MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString("TAG")?.let {
            genre = it
        }
        adapter = TrackAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrackBinding.inflate(layoutInflater)
        viewModel.getTrack(genre)
        observeViewModel()
        return binding.root
    }

    private fun observeViewModel(){
        viewModel.getTrackLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is BaseResponse.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is BaseResponse.Success -> {
                    binding.progressBar.visibility = View.GONE
                    val controller =
                        AnimationUtils.loadLayoutAnimation(requireContext(), R.anim.dropanimatiolayout)
                    binding.trackAlbum.layoutAnimation = controller
                    binding.trackAlbum.scheduleLayoutAnimation()
                    binding.trackAlbum.adapter = adapter
                    adapter.submitList(it.data?.tracks?.track)

                }
                is BaseResponse.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), it.msg, Toast.LENGTH_LONG).show()
                }
                else->{binding.progressBar.visibility = View.GONE}
            }
        }
    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            TrackFragment().apply {
                arguments = Bundle().apply {
                    putString("TAG",param1)
                }
            }
    }
}