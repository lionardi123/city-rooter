package com.example.cityrooter.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cityrooter.core.reader.JsonFileReaderService
import com.example.cityrooter.datamodel.ProfileResponseModel
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    internal val jsonFileReaderService: JsonFileReaderService
): ViewModel() {
    val banner: MutableLiveData<String> by lazy {
        MutableLiveData()
    }

    val aboutTitleBanner: MutableLiveData<String> by lazy {
        MutableLiveData()
    }

    val aboutDesc: MutableLiveData<String> by lazy {
        MutableLiveData()
    }

    internal fun setData(profileResponseModel: ProfileResponseModel){
        banner.value = profileResponseModel.banner
        aboutTitleBanner.value = profileResponseModel.aboutTitleBanner
        aboutDesc.value = profileResponseModel.aboutDescription
    }
}