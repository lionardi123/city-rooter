package com.example.cityrooter.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.navGraphViewModels
import coil.load
import coil.size.Scale
import com.example.cityrooter.R
import com.example.cityrooter.databinding.HomeFragmentBinding
import com.example.cityrooter.datamodel.CustSummaryModel
import com.example.cityrooter.datamodel.HomeResponseModel
import com.example.cityrooter.datamodel.TitleLabelImageModel
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
        return homeFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        loadData()
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
        val observerCarousel = Observer<List<String>> { newCarouselImages ->
            homeFragmentBinding.carouselWidget.setData(newCarouselImages)
        }
        val observerBannerImage = Observer<String> { newBannerImage ->
            homeFragmentBinding.bannerImageView.load(newBannerImage)
        }
        val observerMainInfoList = Observer<List<TitleLabelImageModel>> { newMainInfoList ->

        }
        val observerSellingPoints = Observer<List<TitleLabelImageModel>> { newSellingPoints ->

        }
        val observerAdVideo = Observer<String> { newAdVideo ->

        }
        val observerAboutUs = Observer<String> { newAboutUsVideo ->

        }
        val observerCustSummaries = Observer<List<CustSummaryModel>> { newCustSummaries ->

        }
        val observerSuperiorities = Observer<List<String>> { newSuperiorities ->

        }
        val observerServices = Observer<List<String>> { newServices ->

        }
        val observerGalleries = Observer<List<String>> { newGalleries ->

        }
        viewModel.headerImageList.observe(viewLifecycleOwner, observerCarousel)
        viewModel.bannerImage.observe(viewLifecycleOwner, observerBannerImage)
        viewModel.mainInfoList.observe(viewLifecycleOwner, observerMainInfoList)
        viewModel.sellingPoints.observe(viewLifecycleOwner, observerSellingPoints)
        viewModel.adVideo.observe(viewLifecycleOwner, observerAdVideo)
        viewModel.aboutUs.observe(viewLifecycleOwner, observerAboutUs)
        viewModel.custSummaries.observe(viewLifecycleOwner, observerCustSummaries)
        viewModel.superiorities.observe(viewLifecycleOwner, observerSuperiorities)
        viewModel.services.observe(viewLifecycleOwner, observerServices)
        viewModel.galleries.observe(viewLifecycleOwner, observerGalleries)
    }

    private fun initWidgets(){
        homeFragmentBinding.carouselWidget.fragment = this
    }
}