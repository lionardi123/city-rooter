package com.id.cityrooter.home.widgets.about

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.findNavController
import com.bumptech.glide.Glide

import com.id.cityrooter.R
import com.id.cityrooter.core.views.CoreFrameLayout
import com.id.cityrooter.databinding.AboutWidgetBinding

class AboutWidget(context: Context, attributeSet: AttributeSet) :
    CoreFrameLayout(context, attributeSet) {

    private lateinit var binding: AboutWidgetBinding
    private lateinit var viewModel: AboutViewModel

    override fun onCreateView(): View {
        binding = AboutWidgetBinding.inflate(LayoutInflater.from(context), this, true)
        viewModel = AboutViewModel_Factory.newInstance()
        setListeners()
        return binding.root
    }

    fun setData(data: AboutViewModel) {
        viewModel.setData(data)
        bindToView()
    }

    private fun setListeners(){
        binding.aboutBtn.setOnClickListener {
            findNavController().navigate(R.id.profileFragment)
        }
    }

    private fun bindToView(){
        Glide.with(context).load(viewModel.titleBanner).into(binding.aboutTitleBanner)
        binding.aboutDesc.text = viewModel.aboutDesc
    }
}