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
import com.example.musicwiki.databinding.FragmentArtistBinding
import com.example.musicwiki.fragment.adapter.ArtistAdapter
import com.example.musicwiki.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistFragment : Fragment(),ArtistAdapter.OnClick {
    private var param1: String = ""
    private lateinit var adapter: ArtistAdapter
    private val viewModel :MainViewModel by viewModels()
    private lateinit var binding:FragmentArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString("TAG")?.let {
            param1 = it
        }
        adapter = ArtistAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentArtistBinding.inflate(layoutInflater)
        viewModel.getArtist(param1)
        observeViewModel()
        return binding.root
    }
    private fun observeViewModel(){
        viewModel.getArtistLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is BaseResponse.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is BaseResponse.Success -> {
                    binding.progressBar.visibility = View.GONE
                    val controller =
                        AnimationUtils.loadLayoutAnimation(requireContext(), R.anim.dropanimatiolayout)
                    binding.artistRecyclerview.layoutAnimation = controller
                    binding.artistRecyclerview.scheduleLayoutAnimation()
                    binding.artistRecyclerview.adapter = adapter
                    adapter.submitList(it.data?.topartists?.artist)

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
            ArtistFragment().apply {
                arguments = Bundle().apply {
                    putString("TAG", param1)
                }
            }
    }

    override fun onCLick(name: String) {
        val bundle = Bundle()
        bundle.putString("NAME",name)
        findNavController().navigate(R.id.action_genreInfoFragment_to_artistInfoFragment,bundle)
    }
}