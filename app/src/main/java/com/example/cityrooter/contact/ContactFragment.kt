package com.example.cityrooter.contact

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.cityrooter.databinding.ContactFragmentBinding
import com.example.cityrooter.datamodel.ContactUsResponseModel
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
        setListeners()
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

    private fun setListeners(){
        binding.sendBtn.setOnClickListener {
            openGmailIntent()
        }
    }

    private fun openGmailIntent(){
        try {
            val selectorIntent = Intent(Intent.ACTION_SENDTO)
            selectorIntent.data = Uri.parse("mailto:")

            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("marketing@cityrooter.id"))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contact City Rooter")
            emailIntent.putExtra(Intent.EXTRA_TEXT, binding.editTextMessage.text)
            emailIntent.selector = selectorIntent

            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}