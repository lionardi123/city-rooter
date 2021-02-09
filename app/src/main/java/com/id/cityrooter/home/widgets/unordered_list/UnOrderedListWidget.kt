package com.id.cityrooter.home.widgets.unordered_list

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.bumptech.glide.Glide

import com.id.cityrooter.core.views.CoreFrameLayout
import com.id.cityrooter.databinding.UnorderedListItemLayoutBinding
import com.id.cityrooter.databinding.UnorderedListWidgetBinding

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
        Glide.with(context).load(viewModel.titleBanner).into(binding.unorderedListTitleBanner)

        viewModel.itemList.forEach {
            val binding = UnorderedListItemLayoutBinding.inflate(LayoutInflater.from(context), binding.listContainer, true)
            binding.textViewLabel.text = it
        }
    }
}