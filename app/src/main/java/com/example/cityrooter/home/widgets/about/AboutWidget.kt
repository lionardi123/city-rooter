package com.example.cityrooter.home.widgets.about

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.findNavController
import coil.load
import com.example.cityrooter.R
import com.example.cityrooter.core.views.CoreFrameLayout
import com.example.cityrooter.databinding.AboutWidgetBinding

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
        binding.aboutTitleBanner.load(viewModel.titleBanner)
        binding.aboutDesc.text = viewModel.aboutDesc
    }
}