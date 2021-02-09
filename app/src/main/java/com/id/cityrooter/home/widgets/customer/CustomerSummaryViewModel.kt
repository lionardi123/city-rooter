package com.id.cityrooter.home.widgets.customer

import androidx.lifecycle.ViewModel
import com.id.cityrooter.datamodel.CustSummaryModel
import javax.inject.Inject

class CustomerSummaryViewModel @Inject constructor(): ViewModel() {
    lateinit var titleBanner: String
    lateinit var customerSummaryList: List<CustSummaryModel>

    fun setData(data: CustomerSummaryViewModel) {
        titleBanner = data.titleBanner
        customerSummaryList = data.customerSummaryList
    }

    fun getSummaryValue(custSummaryModel: CustSummaryModel): String {
        var valueString = minOf(custSummaryModel.total, custSummaryModel.threshold).toString()
        if(custSummaryModel.total > custSummaryModel.threshold) valueString += "+"
        return valueString
    }
}