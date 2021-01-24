package com.example.cityrooter.home.widgets.gallery

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.core.view.doOnAttach
import androidx.gridlayout.widget.GridLayout
import coil.load
import com.example.cityrooter.core.views.CoreFrameLayout
import com.example.cityrooter.databinding.GalleryWidgetBinding
import com.example.cityrooter.databinding.ItemGalleryLayoutBinding

class GalleryWidget(context: Context, attributeSet: AttributeSet) :
    CoreFrameLayout(context, attributeSet) {

    private lateinit var binding: GalleryWidgetBinding
    private lateinit var viewModel: GalleryViewModel

    override fun onCreateView(): View {
        binding = GalleryWidgetBinding.inflate(LayoutInflater.from(context), this, true)
        viewModel = GalleryViewModel_Factory.newInstance()
        return binding.root
    }

    fun setData(data: GalleryViewModel){
        viewModel.setData(data)
        bindToView()
    }

    private fun bindToView(){
        binding.galleryTitleBanner.load(viewModel.titleBanner)
        viewModel.galleryItems.forEach {
            val galleryBinding = ItemGalleryLayoutBinding.inflate(LayoutInflater.from(context), binding.galleryContainer, true)
            galleryBinding.galleryImageView.load(it)
            galleryBinding.rootLayout.doOnAttach { view ->
                val gridLayoutParams = (view.layoutParams as GridLayout.LayoutParams)
                gridLayoutParams.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
            }
        }
    }
}