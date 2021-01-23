package com.example.cityrooter.home.widgets.carousel.fragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import javax.inject.Inject

class CarouselItemViewModel @ViewModelInject constructor(): ViewModel() {
    val imageUrl: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    internal fun setData(data: CarouselItemDataModel?){
        imageUrl.value = "https://cityrooter.id/wp-content/uploads/2020/11/toilet-mampet.jpg"
    }
}