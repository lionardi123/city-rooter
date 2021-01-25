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
import com.example.cityrooter.home.widgets.about.AboutViewModel
import com.example.cityrooter.home.widgets.customer.CustomerSummaryViewModel
import com.example.cityrooter.home.widgets.gallery.GalleryViewModel
import com.example.cityrooter.home.widgets.selling_points.SellingPointsViewModel
import com.example.cityrooter.home.widgets.unordered_list.UnOrderedListViewModel
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
            homeFragmentBinding.basicInfoWidget.setData(newMainInfoList)
        }
        val observerSellingPoints = Observer<SellingPointsViewModel> { newSellingPoints ->
            homeFragmentBinding.sellingPointsWidget.setData(newSellingPoints)
        }
        val observerAdVideo = Observer<String> { newAdVideo ->

        }
        val observerAboutUs = Observer<AboutViewModel> { newAboutUs ->
            homeFragmentBinding.aboutWidget.setData(newAboutUs)
        }
        val observerCustSummaries = Observer<CustomerSummaryViewModel> { newCustSummaries ->
            homeFragmentBinding.custSummaryWidget.setData(newCustSummaries)
        }
        val observerSuperiorities = Observer<UnOrderedListViewModel> { newSuperiorities ->
            homeFragmentBinding.superioritiesWidget.setData(newSuperiorities)
        }
        val observerServices = Observer<UnOrderedListViewModel> { newServices ->
            homeFragmentBinding.servicesWidget.setData(newServices)
        }
        val observerGalleries = Observer<GalleryViewModel> { newGalleries ->
            homeFragmentBinding.galleryWidget.setData(newGalleries)
        }
        val observerAddress = Observer<String> { address ->
            homeFragmentBinding.textViewLocation.text = address
        }
        val observerPhone = Observer<String> { phone ->
            homeFragmentBinding.textViewPhone.text = phone
        }
        val observerEmail = Observer<String> { email ->
            homeFragmentBinding.textViewEmail.text = email
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
        viewModel.address.observe(viewLifecycleOwner, observerAddress)
        viewModel.phone.observe(viewLifecycleOwner, observerPhone)
        viewModel.email.observe(viewLifecycleOwner, observerEmail)
    }

    private fun initWidgets(){
        homeFragmentBinding.carouselWidget.fragment = this
    }
}