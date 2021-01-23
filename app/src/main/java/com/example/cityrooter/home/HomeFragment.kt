package com.example.cityrooter.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.navGraphViewModels
import coil.load
import coil.size.Scale
import com.example.cityrooter.R
import com.example.cityrooter.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by navGraphViewModels(R.id.navHostContainer) {
        defaultViewModelProviderFactory
    }

    private lateinit var homeFragmentBinding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeFragmentBinding = HomeFragmentBinding.inflate(layoutInflater)
        initWidgets()
        return homeFragmentBinding.root
    }

    private fun initWidgets(){
        homeFragmentBinding.carouselWidget.fragmentRetriever = {this}
        homeFragmentBinding.bannerImageView.load("https://cityrooter.id/wp-content/uploads/2020/11/layanan-pipa-mampet-palembang-1.jpg")
    }
}