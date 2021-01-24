package com.example.cityrooter.home

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.cityrooter.core.reader.JsonFileReaderService
import com.example.cityrooter.datamodel.CustSummaryModel
import com.example.cityrooter.datamodel.HomeResponseModel
import com.example.cityrooter.datamodel.TitleLabelImageModel
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

    val sellingPoints: MutableLiveData<List<TitleLabelImageModel>> by lazy {
        MutableLiveData<List<TitleLabelImageModel>>()
    }

    val adVideo: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val aboutUs: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val custSummaries: MutableLiveData<List<CustSummaryModel>> by lazy {
        MutableLiveData<List<CustSummaryModel>>()
    }

    val superiorities: MutableLiveData<List<String>> by lazy {
        MutableLiveData<List<String>>()
    }

    val services: MutableLiveData<List<String>> by lazy {
        MutableLiveData<List<String>>()
    }

    val galleries: MutableLiveData<List<String>> by lazy {
        MutableLiveData<List<String>>()
    }

    fun setData(homeResponseModel: HomeResponseModel){
        headerImageList.value = homeResponseModel.headerImageList
        bannerImage.value = homeResponseModel.bannerImage
        mainInfoList.value = homeResponseModel.mainInfoList
        sellingPoints.value = homeResponseModel.sellingPoints
        adVideo.value = homeResponseModel.adVideo
        aboutUs.value = homeResponseModel.aboutUs
        custSummaries.value = homeResponseModel.custSummaries
        superiorities.value = homeResponseModel.superiorities
        services.value = homeResponseModel.services
        galleries.value = homeResponseModel.galleries
    }
}