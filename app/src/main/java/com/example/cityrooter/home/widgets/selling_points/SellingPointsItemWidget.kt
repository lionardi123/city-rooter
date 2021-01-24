package com.example.cityrooter.home.widgets.selling_points

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.gridlayout.widget.GridLayout
import coil.load
import com.example.cityrooter.core.views.CoreFrameLayout
import com.example.cityrooter.databinding.SellingPointsItemWidgetBinding
import com.example.cityrooter.datamodel.TitleLabelImageModel

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
        binding.itemImageView.load(item.imageUrl)
        binding.itemTitle.text = item.title
        binding.itemDesc.text = item.description
    }
}