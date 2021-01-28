package com.example.cityrooter.home

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import coil.load
import com.example.cityrooter.databinding.HomeFragmentBinding
import com.example.cityrooter.datamodel.HomeResponseModel
import com.example.cityrooter.datamodel.TitleLabelImageModel
import com.example.cityrooter.home.widgets.about.AboutViewModel
import com.example.cityrooter.home.widgets.customer.CustomerSummaryViewModel
import com.example.cityrooter.home.widgets.gallery.GalleryViewModel
import com.example.cityrooter.home.widgets.selling_points.SellingPointsViewModel
import com.example.cityrooter.home.widgets.unordered_list.UnOrderedListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class HomeFragment : Fragment() {

    @Inject lateinit var viewModel: HomeViewModel

    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(layoutInflater)
        initWidgets()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        loadData()
    }

    private fun setListeners(){
        binding.whatsappBtn.setOnClickListener {

        }

        binding.igBtn.setOnClickListener {
            openInstagram()
        }

        binding.facebookImageView.setOnClickListener {
            openFacebook()
        }

        binding.instagramImageView.setOnClickListener {
            openInstagram()
        }

        binding.youtubeImageView.setOnClickListener {
            openYoutube()
        }
    }

    fun openFacebook() {
        try {
            context?.packageManager?.getPackageInfo("com.facebook.katana", 0)
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/cityrooter.id")))
        } catch (e: Exception) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/cityrooter.id")))
        }
    }

    private fun openYoutube() {
        val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:ih2qSy6mrik"))
        val webIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("http://www.youtube.com/watch?v=ih2qSy6mrik")
        )
        try {
            startActivity(appIntent)
        } catch (ex: ActivityNotFoundException) {
            startActivity(webIntent)
        }
    }

    private fun openInstagram(){
        val uri = Uri.parse("http://instagram.com/_u/cityrooter.id")
        val likeIng = Intent(Intent.ACTION_VIEW, uri)

        likeIng.setPackage("com.instagram.android")

        try {
            startActivity(likeIng)
        } catch (e: ActivityNotFoundException) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/cityrooter.id")
                )
            )
        }
    }

    private fun loadData(){
        val immutableContext = context
        if(immutableContext != null){
            val data = viewModel.jsonFileReaderService.getJsonFromAssets(
                immutableContext,
                "homeResponse.json",
                HomeResponseModel::class
            )
            if(data != null)
            viewModel.setData(
                data
            )
        }
    }

    private fun observeData() {
        val observerCarousel = Observer<List<String>> { newCarouselImages ->
            binding.carouselWidget.setData(newCarouselImages)
        }
        val observerBannerImage = Observer<String> { newBannerImage ->
            binding.bannerImageView.load(newBannerImage)
        }
        val observerMainInfoList = Observer<List<TitleLabelImageModel>> { newMainInfoList ->
            binding.basicInfoWidget.setData(newMainInfoList)
        }
        val observerSellingPoints = Observer<SellingPointsViewModel> { newSellingPoints ->
            binding.sellingPointsWidget.setData(newSellingPoints)
        }
        val observerAdVideo = Observer<String> { newAdVideo ->

        }
        val observerAboutUs = Observer<AboutViewModel> { newAboutUs ->
            binding.aboutWidget.setData(newAboutUs)
        }
        val observerCustSummaries = Observer<CustomerSummaryViewModel> { newCustSummaries ->
            binding.custSummaryWidget.setData(newCustSummaries)
        }
        val observerSuperiorities = Observer<UnOrderedListViewModel> { newSuperiorities ->
            binding.superioritiesWidget.setData(newSuperiorities)
        }
        val observerServices = Observer<UnOrderedListViewModel> { newServices ->
            binding.servicesWidget.setData(newServices)
        }
        val observerGalleries = Observer<GalleryViewModel> { newGalleries ->
            binding.galleryWidget.setData(newGalleries)
        }
        val observerAddress = Observer<String> { address ->
            binding.textViewLocation.text = address
        }
        val observerPhone = Observer<String> { phone ->
            binding.textViewPhone.text = phone
        }
        val observerEmail = Observer<String> { email ->
            binding.textViewEmail.text = email
        }

        viewModel.headerImageList.observe(viewLifecycleOwner, observerCarousel)
        viewModel.bannerImage.observe(viewLifecycleOwner, observerBannerImage)
        viewModel.mainInfoList.observe(viewLifecycleOwner, observerMainInfoList)
        viewModel.sellingPoints.observe(viewLifecycleOwner, observerSellingPoints)
        viewModel.adVideo.observe(viewLifecycleOwner, observerAdVideo)
        viewModel.aboutUs.observe(viewLifecycleOwner, observerAboutUs)
        viewModel.custSummaries.observe(viewLifecycleOwner, observerCustSummaries)
        viewModel.superiorities.observe(viewLifecycleOwner, observerSuperiorities)
        viewModel.services.observe(viewLifecycleOwner, observerServices)
        viewModel.galleries.observe(viewLifecycleOwner, observerGalleries)
        viewModel.address.observe(viewLifecycleOwner, observerAddress)
        viewModel.phone.observe(viewLifecycleOwner, observerPhone)
        viewModel.email.observe(viewLifecycleOwner, observerEmail)
    }

    private fun initWidgets(){
        binding.carouselWidget.fragment = this
        setListeners()
    }
}