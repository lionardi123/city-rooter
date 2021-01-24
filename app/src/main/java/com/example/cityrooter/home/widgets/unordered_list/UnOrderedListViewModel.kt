package com.example.cityrooter.home.widgets.unordered_list

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class UnOrderedListViewModel @Inject constructor(): ViewModel() {
    lateinit var titleBanner: String
    lateinit var itemList: List<String>

    fun setData(data: UnOrderedListViewModel) {
        titleBanner = data.titleBanner
        itemList = data.itemList
    }
}