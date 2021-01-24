package com.example.cityrooter.home.widgets.carousel.adapter

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.example.cityrooter.home.widgets.carousel.fragment.CarouselItemDataModel
import com.example.cityrooter.home.widgets.carousel.fragment.CarouselItemFragment

class CarouselAdapter(fragment: Fragment,
                      var data: List<String>): FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int {
        return data.size
    }

    override fun createFragment(position: Int): Fragment {
        return CarouselItemFragment().also {
            it.arguments = Bundle().also {
                it.putParcelable(CarouselItemFragment.PARAM, CarouselItemDataModel(data[position]))
            }
        }
    }
}