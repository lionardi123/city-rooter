package com.example.cityrooter.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
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
import com.example.cityrooter.datamodel.HomeResponseModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    @Inject lateinit var viewModel: HomeViewModel

    private lateinit var homeFragmentBinding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeFragmentBinding = HomeFragmentBinding.inflate(layoutInflater)
        initWidgets()
        observeData()
        loadData()
        return homeFragmentBinding.root
    }

    private fun loadData(){
        val immutableContext = context
        if(immutableContext != null){
            val data = viewModel.jsonFileReaderService.getJsonFromAssets(
                immutableContext,
                "homeResponse.json",
                HomeResponseModel::class
            )
            if(data != null)
            viewModel.setData(
                data
            )
        }
    }

    private fun observeData() {

    }

    private fun initWidgets(){
        homeFragmentBinding.carouselWidget.fragmentRetriever = {this}
    }
}