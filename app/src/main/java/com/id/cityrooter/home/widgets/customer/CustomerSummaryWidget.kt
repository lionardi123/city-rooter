package com.id.cityrooter.home.widgets.customer

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.bumptech.glide.Glide

import com.id.cityrooter.core.views.CoreFrameLayout
import com.id.cityrooter.databinding.CustomerSummaryWidgetBinding

class CustomerSummaryWidget(context: Context, attributeSet: AttributeSet): CoreFrameLayout(context, attributeSet) {

    private lateinit var binding: CustomerSummaryWidgetBinding
    private lateinit var viewModel: CustomerSummaryViewModel

    override fun onCreateView(): View {
        binding = CustomerSummaryWidgetBinding.inflate(LayoutInflater.from(context), this, true)
        viewModel = CustomerSummaryViewModel_Factory.newInstance()
        return binding.root
    }

    fun setData(data: CustomerSummaryViewModel) {
        viewModel.setData(data)
        bindToView()
    }

    private fun bindToView(){
        Glide.with(context).load(viewModel.titleBanner).into(binding.customerTitleBanner)

        val commercialItem = viewModel.customerSummaryList[0]
        binding.textViewCommercialValue.text = viewModel.getSummaryValue(commercialItem)
        binding.textViewCommercialTitle.text = commercialItem.category

        val residentialItem = viewModel.customerSummaryList[1]
        binding.textViewResidentialValue.text = viewModel.getSummaryValue(residentialItem)
        binding.textViewResidentialTitle.text = residentialItem.category

        val othersItem = viewModel.customerSummaryList[2]
        binding.textViewOthersValue.text = viewModel.getSummaryValue(othersItem)
        binding.textViewOthersTitle.text = othersItem.category
    }
}