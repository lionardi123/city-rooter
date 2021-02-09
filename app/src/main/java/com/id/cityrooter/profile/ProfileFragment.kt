package com.id.cityrooter.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.navGraphViewModels
import com.bumptech.glide.Glide

import com.id.cityrooter.R
import com.id.cityrooter.databinding.ProfileFragmentBinding
import com.id.cityrooter.datamodel.HomeResponseModel
import com.id.cityrooter.datamodel.ProfileResponseModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment: Fragment() {

    private lateinit var binding: ProfileFragmentBinding
    @Inject lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProfileFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        loadData()
    }

    private fun observeData(){
        val observerBanner = Observer<String> { newBanner ->
            Glide.with(this).load(newBanner).into(binding.bannerImageView)
        }
        val observerAboutTitleBanner = Observer<String> { newAboutTitleBanner ->
            Glide.with(this).load(newAboutTitleBanner).into(binding.aboutTitleBanner)
        }
        val observerAboutDesc = Observer<String> { newAboutDesc ->
            binding.aboutDesc.text = newAboutDesc
        }

        viewModel.banner.observe(viewLifecycleOwner, observerBanner)
        viewModel.aboutTitleBanner.observe(viewLifecycleOwner, observerAboutTitleBanner)
        viewModel.aboutDesc.observe(viewLifecycleOwner, observerAboutDesc)
    }

    private fun loadData(){
        val immutableContext = context
        if(immutableContext != null){
            val data = viewModel.jsonFileReaderService.getJsonFromAssets(
                immutableContext,
                "profileResponse.json",
                ProfileResponseModel::class
            )
            if(data != null)
                viewModel.setData(
                    data
                )
        }
    }

}