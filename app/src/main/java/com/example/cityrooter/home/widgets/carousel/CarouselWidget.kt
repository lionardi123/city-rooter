package com.example.cityrooter.home.widgets.carousel

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
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
        adapter = CarouselAdapter(fragmentRetriever.invoke(),
            listOf("https://cityrooter.id/wp-content/uploads/2020/11/toilet-mampet.jpg",
                "https://cityrooter.id/wp-content/uploads/2020/11/toilet-mampet.jpg",
                "https://cityrooter.id/wp-content/uploads/2020/11/toilet-mampet.jpg"
        ))
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ -> }.attach()
        binding.btnLeft.setOnClickListener { binding.viewPager.setCurrentItem((binding.viewPager.currentItem - 1).takeIf { it >= 0 } ?: adapter.itemCount - 1) }
        binding.btnRight.setOnClickListener { binding.viewPager.setCurrentItem((binding.viewPager.currentItem + 1).takeIf { it <= adapter.itemCount - 1 } ?: 0)  }
    }
}