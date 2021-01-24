package com.example.cityrooter.home.widgets.unordered_list

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import coil.load
import com.example.cityrooter.core.views.CoreFrameLayout
import com.example.cityrooter.databinding.UnorderedListItemLayoutBinding
import com.example.cityrooter.databinding.UnorderedListWidgetBinding

class UnOrderedListWidget(context: Context, attributeSet: AttributeSet): CoreFrameLayout(context, attributeSet) {

    private lateinit var binding: UnorderedListWidgetBinding
    private lateinit var viewModel: UnOrderedListViewModel

    override fun onCreateView(): View {
        binding = UnorderedListWidgetBinding.inflate(LayoutInflater.from(context), this, true)
        viewModel = UnOrderedListViewModel_Factory.newInstance()
        return binding.root
    }

    fun setData(data: UnOrderedListViewModel){
        viewModel.setData(data)
        bindToView()
    }

    private fun bindToView(){
        binding.unorderedListTitleBanner.load(viewModel.titleBanner)
        viewModel.itemList.forEach {
            val binding = UnorderedListItemLayoutBinding.inflate(LayoutInflater.from(context), binding.listContainer, true)
            binding.textViewLabel.text = it
        }
    }
}