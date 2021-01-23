package com.example.cityrooter.home.widgets.carousel.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cityrooter.home.widgets.carousel.fragment.CarouselItemFragment
import com.example.cityrooter.home.widgets.carousel.fragment.CarouselItemViewModel

class CarouselAdapter(fragment: Fragment,
                      val data: List<String>): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return data.size
    }

    override fun createFragment(position: Int): Fragment {
        return CarouselItemFragment().also {
            it.setData(CarouselItemViewModel().also {
                it.imageUrl.value = data[position]
            })
        }
    }
}