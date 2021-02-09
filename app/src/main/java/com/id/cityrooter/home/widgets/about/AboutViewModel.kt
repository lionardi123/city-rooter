package com.id.cityrooter.home.widgets.about

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class AboutViewModel @Inject constructor(): ViewModel() {
    lateinit var titleBanner: String
    lateinit var aboutDesc: String

    fun setData(data: AboutViewModel) {
        titleBanner = data.titleBanner
        aboutDesc = data.aboutDesc
    }
}