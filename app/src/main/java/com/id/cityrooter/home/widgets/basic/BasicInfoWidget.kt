package com.id.cityrooter.home.widgets.basic

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide

import com.id.cityrooter.core.views.CoreFrameLayout
import com.id.cityrooter.databinding.BasicInfoWidgetBinding
import com.id.cityrooter.datamodel.TitleLabelImageModel
import javax.inject.Inject

class BasicInfoWidget(context: Context, attributeSet: AttributeSet) :
    CoreFrameLayout(context, attributeSet) {

    private lateinit var binding: BasicInfoWidgetBinding
    private lateinit var viewModel: BasicInfoViewModel

    override fun onCreateView(): View {
        binding = BasicInfoWidgetBinding.inflate(LayoutInflater.from(context), this, true)
        viewModel = BasicInfoViewModel_Factory.newInstance()
        return binding.root
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        observeData()
    }

    fun setData(infoList: List<TitleLabelImageModel>) {
        viewModel.setData(infoList)
        bindToView(binding.imageViewFirst, binding.textViewTitleFirst, binding.textViewDescFirst,
            viewModel.firstItemModel.imageUrl, viewModel.firstItemModel.title, viewModel.firstItemModel.description)
        bindToView(binding.imageViewSecond, binding.textViewTitleSecond, binding.textViewDescSecond,
            viewModel.secondItemModel.imageUrl, viewModel.secondItemModel.title, viewModel.secondItemModel.description)
        bindToView(binding.imageViewThird, binding.textViewTitleThird, binding.textViewDescThird,
            viewModel.thirdItemModel.imageUrl, viewModel.thirdItemModel.title, viewModel.thirdItemModel.description)
    }

    //TODO: Research DataBinding vs LiveData
    private fun observeData(){
//        val immutableLifecycleOwner = lifecycleOwner
//        if(immutableLifecycleOwner == null) return
//        val observerFirstItem = Observer<TitleLabelImageModel> { newFirstItem ->
//
//        }
//        val observerSecondItem = Observer<TitleLabelImageModel> { newSecondItem ->
//
//        }
//        val observerThirdItem = Observer<TitleLabelImageModel> { newThirdItem ->
//
//        }
//
//        viewModel.firstItemModel.observe(immutableLifecycleOwner, observerFirstItem)
//        viewModel.secondItemModel.observe(immutableLifecycleOwner, observerSecondItem)
//        viewModel.thirdItemModel.observe(immutableLifecycleOwner, observerThirdItem)
    }

    private fun bindToView(
        imageView: ImageView,
        titleTextView: TextView,
        descriptionTextView: TextView,
        imageUrl: String,
        title: String,
        description: String
    ) {
        Glide.with(context).load(imageUrl).into(imageView)
        titleTextView.text = title
        descriptionTextView.text = description
    }
}