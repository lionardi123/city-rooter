package com.example.cityrooter.home.widgets.carousel.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import coil.load
import com.example.cityrooter.databinding.CarouselItemFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CarouselItemFragment :  Fragment() {

    private val viewModel: CarouselItemViewModel by viewModels()
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
        setData(arguments?.getParcelable(PARAM))
        observeData()
    }

    private fun observeData(){
        val imageObserver = Observer<String> { imageUrl ->
            binding.carouselImageView.load(imageUrl)
        }

        viewModel.imageUrl.observe(viewLifecycleOwner, imageObserver)
    }

    private fun setData(data: CarouselItemDataModel?){
        viewModel.setData(data)
    }

    companion object {
        const val PARAM = "PARAM"
    }
}