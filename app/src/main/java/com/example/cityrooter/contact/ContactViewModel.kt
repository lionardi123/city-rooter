package com.example.cityrooter.contact

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cityrooter.core.reader.JsonFileReaderService
import com.example.cityrooter.datamodel.ContactUsResponseModel
import javax.inject.Inject

class ContactViewModel @Inject constructor(
    internal val fileReaderService: JsonFileReaderService
): ViewModel() {

    val address: MutableLiveData<String> by lazy {
        MutableLiveData()
    }

    val email: MutableLiveData<String> by lazy {
        MutableLiveData()
    }

    val phone: MutableLiveData<String> by lazy {
        MutableLiveData()
    }

    fun setData(data: ContactUsResponseModel){
        address.value = data.address
        email.value = data.email
        phone.value = data.phone
    }
}