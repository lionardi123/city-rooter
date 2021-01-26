package com.example.cityrooter.contact

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.navGraphViewModels
import com.example.cityrooter.R
import com.example.cityrooter.databinding.ContactFragmentBinding
import com.example.cityrooter.datamodel.ContactUsResponseModel
import com.example.cityrooter.datamodel.HomeResponseModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ContactFragment : Fragment() {

    private lateinit var binding: ContactFragmentBinding
    @Inject lateinit var viewModel: ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ContactFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        loadData()
    }

    private fun observeViewModel(){
        val observerAddress = Observer<String> { newAddress ->
            binding.textViewLocation.text = newAddress
        }

        val observerPhone = Observer<String> { newPhone ->
            binding.textViewPhone.text = newPhone
        }

        val observerEmail = Observer<String> { newEmail ->
            binding.textViewEmail.text = newEmail
        }

        viewModel.address.observe(viewLifecycleOwner, observerAddress)
        viewModel.phone.observe(viewLifecycleOwner, observerPhone)
        viewModel.email.observe(viewLifecycleOwner, observerEmail)
    }
    private fun loadData(){
        val immutableContext = context
        if(immutableContext != null){
            val data = viewModel.fileReaderService.getJsonFromAssets(
                immutableContext,
                "contactUsResponse.json",
                ContactUsResponseModel::class
            )
            if(data != null)
                viewModel.setData(
                    data
                )
        }
    }
}