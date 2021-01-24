package com.example.cityrooter.home.widgets.selling_points

import com.example.cityrooter.datamodel.TitleLabelImageModel
import javax.inject.Inject

class SellingPointsViewModel @Inject constructor() {
    lateinit var banner: String
    lateinit var sellingPointItems: List<TitleLabelImageModel>

    fun setData(data: SellingPointsViewModel) {
        this.banner = data.banner
        this.sellingPointItems = data.sellingPointItems
    }
}