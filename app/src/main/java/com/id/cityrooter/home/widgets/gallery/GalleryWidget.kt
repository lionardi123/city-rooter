package com.id.cityrooter.home.widgets.gallery

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.core.view.doOnAttach
import androidx.gridlayout.widget.GridLayout
import com.bumptech.glide.Glide

import com.id.cityrooter.core.views.CoreFrameLayout
import com.id.cityrooter.databinding.GalleryWidgetBinding
import com.id.cityrooter.databinding.ItemGalleryLayoutBinding

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
        Glide.with(context).load(viewModel.titleBanner).into(binding.galleryTitleBanner)

        viewModel.galleryItems.forEach {
            val galleryBinding = ItemGalleryLayoutBinding.inflate(LayoutInflater.from(context), binding.galleryContainer, true)
            Glide.with(context).load(it).into(galleryBinding.galleryImageView)
            galleryBinding.rootLayout.doOnAttach { view ->
                val gridLayoutParams = (view.layoutParams as GridLayout.LayoutParams)
                gridLayoutParams.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
            }
        }
    }
}