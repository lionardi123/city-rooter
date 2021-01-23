package com.example.cityrooter.home.widgets.carousel

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.cityrooter.core.views.CoreFrameLayout
import com.example.cityrooter.databinding.CarouselWidgetBinding
import com.example.cityrooter.home.widgets.carousel.adapter.CarouselAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CarouselWidget(context: Context, attributeSet: AttributeSet): CoreFrameLayout(context, attributeSet) {

    @Inject lateinit var viewModel: CarouselViewModel
    private lateinit var binding: CarouselWidgetBinding

    private lateinit var adapter: CarouselAdapter

    lateinit var fragmentRetriever: (() -> Fragment)

    override fun onCreateView(): View {
        binding = CarouselWidgetBinding.inflate(LayoutInflater.from(context), this, true)
        initViewPager()
        return binding.root
    }

    private fun initViewPager() {
        adapter = CarouselAdapter(fragmentRetriever.invoke(), listOf("https://cityrooter.id/wp-content/uploads/2020/11/toilet-mampet.jpg"))
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->

        }.attach()
    }
}