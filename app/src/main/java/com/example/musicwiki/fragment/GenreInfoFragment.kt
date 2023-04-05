package com.example.musicwiki.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.musicwiki.R
import com.example.musicwiki.api.services.BaseResponse
import com.example.musicwiki.databinding.FragmentGenreInfoBinding
import com.example.musicwiki.fragment.adapter.AlbumAdapter
import com.example.musicwiki.fragment.adapter.ViewPagerAdapter
import com.example.musicwiki.viewmodel.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenreInfoFragment() : Fragment() {

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private val viewModel:MainViewModel by viewModels()
    private lateinit var binding:FragmentGenreInfoBinding
    private var genrename:String=""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGenreInfoBinding.inflate(layoutInflater)
        arguments?.getString("TAG")?.let {
            genrename = it
        }
        viewPagerAdapter = ViewPagerAdapter(requireActivity().supportFragmentManager,lifecycle,genrename)
        viewModel.getGenresInfo(genrename)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        val callback = requireActivity().onBackPressedDispatcher.addCallback(requireActivity()){
            findNavController().popBackStack()
        }
        binding.viewPager2.adapter = viewPagerAdapter
        TabLayoutMediator(binding.tabLayout,binding.viewPager2)
        {
           tab,position->
               when(position){
                   0->{ tab.text = "Album" }
                   1->{tab.text = "Track"}
                   2->{tab.text = "Artist"}

               }
        }.attach()
        for (i in 0 until binding.tabLayout.getTabCount()) {
            val tab = (binding.tabLayout.getChildAt(0) as ViewGroup).getChildAt(i)
            val p = tab.layoutParams as MarginLayoutParams
            p.setMargins(0, 0, 30, 0)
            tab.requestLayout()
        }
    }
  public  fun navTo(){
        findNavController().navigate(R.id.action_genreInfoFragment_to_albumInfoFragment)
    }

    private fun observeViewModel(){
        viewModel.getGenerInfoLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is BaseResponse.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is BaseResponse.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.progressBar.visibility = View.GONE
                    binding.name.text = it.data?.tag?.name
                    binding.disc.text  = it.data?.tag?.wiki?.summary
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