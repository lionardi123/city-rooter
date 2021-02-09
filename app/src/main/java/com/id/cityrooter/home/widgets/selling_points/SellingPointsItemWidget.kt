package com.id.cityrooter.home.widgets.selling_points

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.gridlayout.widget.GridLayout
import com.bumptech.glide.Glide

import com.id.cityrooter.core.views.CoreFrameLayout
import com.id.cityrooter.databinding.SellingPointsItemWidgetBinding
import com.id.cityrooter.datamodel.TitleLabelImageModel

class SellingPointsItemWidget(context: Context, attributeSet: AttributeSet?) :
    CoreFrameLayout(context, attributeSet) {

    lateinit var binding: SellingPointsItemWidgetBinding

    override fun onCreateView(): View {
        binding = SellingPointsItemWidgetBinding.inflate(LayoutInflater.from(context), this, true)
        return binding.root
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        (layoutParams as GridLayout.LayoutParams).columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
    }

    fun setData(item: TitleLabelImageModel){
        Glide.with(context).load(item.imageUrl).into(binding.itemImageView)
        binding.itemTitle.text = item.title
        binding.itemDesc.text = item.description
    }
}