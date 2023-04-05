package com.example.musicwiki.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.musicwiki.R
import com.example.musicwiki.api.services.BaseResponse
import com.example.musicwiki.databinding.FragmentGenersBinding
import com.example.musicwiki.fragment.adapter.GenersAdapter
import com.example.musicwiki.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenersFragment : Fragment(),GenersAdapter.OnClick{
    private lateinit var adapter:GenersAdapter
    private var clicked:Int = 0
    private val viewModel:MainViewModel by viewModels()
    private lateinit var binding: FragmentGenersBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGenersBinding.inflate(layoutInflater)
        adapter = GenersAdapter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getGenres()
        observeViewModel()
        binding.expand.setOnClickListener {
            if(clicked==0){
                binding.expand.setImageResource(R.drawable.ic_up)
                adapter.list_type = true
                adapter.notifyDataSetChanged()
                clicked=1
            }
            else{
                binding.expand.setImageResource(R.drawable.ic_down)
                adapter.list_type = false
                adapter.notifyDataSetChanged()
                clicked=0
            }

        }
        val callback = requireActivity().onBackPressedDispatcher.addCallback(requireActivity()){
           activity?.finish()
        }
    }
    private fun observeViewModel(){
        viewModel.getGenerLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is BaseResponse.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is BaseResponse.Success -> {
                    binding.progressBar.visibility = View.GONE
                    val controller =
                        AnimationUtils.loadLayoutAnimation(requireContext(), R.anim.layoutanimation)
                    binding.recyclerView.layoutAnimation = controller
                    binding.recyclerView.scheduleLayoutAnimation()

                    binding.recyclerView.adapter = adapter
                    adapter.submitList(it.data?.tags?.tag)

                }
                is BaseResponse.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), it.msg, Toast.LENGTH_LONG).show()
                }
                else->{binding.progressBar.visibility = View.GONE}
            }
        }
    }

    override fun onClick(genre: String) {
        val bundle =Bundle()
        bundle.putString("TAG",genre)
        findNavController().navigate(R.id.action_genersFragment_to_genreInfoFragment,bundle)
    }

}