package com.example.cityrooter.home.widgets.carousel.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import javax.inject.Inject

class CarouselItemViewModel @Inject constructor(): ViewModel() {
    val imageUrl: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    internal fun setData(data: CarouselItemViewModel){
        imageUrl.value = data.imageUrl.value
    }
}