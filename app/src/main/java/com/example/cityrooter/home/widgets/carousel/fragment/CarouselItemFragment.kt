package com.example.cityrooter.home.widgets.carousel.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import coil.load
import com.example.cityrooter.R
import com.example.cityrooter.databinding.CarouselItemFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CarouselItemFragment : Fragment() {

    @Inject lateinit var viewModel: CarouselItemViewModel
    private lateinit var binding: CarouselItemFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CarouselItemFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
    }

    private fun observeData(){
        val imageObserver = Observer<String> { imageUrl ->
            binding.carouselImageView.load(imageUrl)
        }

        viewModel.imageUrl.observe(viewLifecycleOwner, imageObserver)
    }

    fun setData(data: CarouselItemViewModel){
        viewModel.setData(data)
    }
}