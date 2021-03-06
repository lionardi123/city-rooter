package com.id.cityrooter.home

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.id.cityrooter.core.reader.JsonFileReaderService
import com.id.cityrooter.datamodel.CustSummaryModel
import com.id.cityrooter.datamodel.HomeResponseModel
import com.id.cityrooter.datamodel.TitleLabelImageModel
import com.id.cityrooter.home.widgets.about.AboutViewModel
import com.id.cityrooter.home.widgets.customer.CustomerSummaryViewModel
import com.id.cityrooter.home.widgets.gallery.GalleryViewModel
import com.id.cityrooter.home.widgets.selling_points.SellingPointsViewModel
import com.id.cityrooter.home.widgets.unordered_list.UnOrderedListViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    val jsonFileReaderService: JsonFileReaderService
) : ViewModel() {
    val headerImageList: MutableLiveData<List<String>> by lazy {
        MutableLiveData<List<String>>()
    }

    val bannerImage: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val mainInfoList: MutableLiveData<List<TitleLabelImageModel>> by lazy {
        MutableLiveData<List<TitleLabelImageModel>>()
    }

    val sellingPoints: MutableLiveData<SellingPointsViewModel> by lazy {
        MutableLiveData<SellingPointsViewModel>()
    }

    val adVideo: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val aboutUs: MutableLiveData<AboutViewModel> by lazy {
        MutableLiveData<AboutViewModel>()
    }

    val custSummaries: MutableLiveData<CustomerSummaryViewModel> by lazy {
        MutableLiveData<CustomerSummaryViewModel>()
    }

    val superiorities: MutableLiveData<UnOrderedListViewModel> by lazy {
        MutableLiveData<UnOrderedListViewModel>()
    }

    val services: MutableLiveData<UnOrderedListViewModel> by lazy {
        MutableLiveData<UnOrderedListViewModel>()
    }

    val galleries: MutableLiveData<GalleryViewModel> by lazy {
        MutableLiveData<GalleryViewModel>()
    }

    val address: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val phone: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val email: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun setData(homeResponseModel: HomeResponseModel){
        headerImageList.value = homeResponseModel.headerImageList
        bannerImage.value = homeResponseModel.bannerImage
        mainInfoList.value = homeResponseModel.mainInfoList
        sellingPoints.value = SellingPointsViewModel().also {
            it.banner = homeResponseModel.sellingPointsBanner
            it.sellingPointItems = homeResponseModel.sellingPoints
        }
        adVideo.value = homeResponseModel.adVideo
        aboutUs.value = AboutViewModel().also {
            it.titleBanner = homeResponseModel.aboutUsBanner
            it.aboutDesc = homeResponseModel.aboutUs
        }
        custSummaries.value = CustomerSummaryViewModel().also {
            it.titleBanner = homeResponseModel.custSummariesBanner
            it.customerSummaryList = homeResponseModel.custSummaries
        }
        superiorities.value = UnOrderedListViewModel().also {
            it.titleBanner = homeResponseModel.superioritiesBanner
            it.itemList = homeResponseModel.superiorities
        }
        services.value = UnOrderedListViewModel().also {
            it.titleBanner = homeResponseModel.servicesBanner
            it.itemList = homeResponseModel.services
        }
        galleries.value = GalleryViewModel().also {
            it.titleBanner = homeResponseModel.galleriesBanner
            it.galleryItems = homeResponseModel.galleries
        }
        address.value = homeResponseModel.address
        phone.value = homeResponseModel.phone
        email.value = homeResponseModel.email
    }
}