package com.id.cityrooter.home.widgets.selling_points

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.GridLayout
import com.bumptech.glide.Glide

import com.id.cityrooter.core.views.CoreFrameLayout
import com.id.cityrooter.databinding.SellingPointsWidgetBinding
import com.id.cityrooter.datamodel.TitleLabelImageModel

class SellingPointsWidget(context: Context, attributeSet: AttributeSet) :
    CoreFrameLayout(context, attributeSet) {

    private lateinit var binding: SellingPointsWidgetBinding
    private lateinit var viewModel: SellingPointsViewModel

    override fun onCreateView(): View {
        binding = SellingPointsWidgetBinding.inflate(LayoutInflater.from(context), this, true)
        viewModel = SellingPointsViewModel_Factory.newInstance()
        initGridLayout()
        return binding.root
    }

    fun setData(data: SellingPointsViewModel){
        viewModel.setData(data)
        bindDataToView()
    }

    private fun bindDataToView(){
        Glide.with(context).load(viewModel.banner).into(binding.sellingTitleBanner)

        viewModel.sellingPointItems.forEach {
            val view = createSellingItemCard(it)
            binding.sellingGridLayout.addView(view)
        }
    }

    private fun initGridLayout(){
        binding.sellingGridLayout.columnCount = 2
    }

    private fun createSellingItemCard(
        titleLabelImageModel: TitleLabelImageModel
    ): SellingPointsItemWidget {
       return SellingPointsItemWidget(context, null).also {
           it.setData(titleLabelImageModel)
       }
    }
}