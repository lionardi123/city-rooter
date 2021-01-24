package com.example.cityrooter.home.widgets.gallery

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class GalleryViewModel @Inject constructor(): ViewModel() {
    lateinit var titleBanner: String
    lateinit var galleryItems: List<String>

    fun setData(data: GalleryViewModel){
        titleBanner = data.titleBanner
        galleryItems = data.galleryItems
    }
}