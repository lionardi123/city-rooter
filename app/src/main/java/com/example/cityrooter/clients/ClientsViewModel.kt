package com.example.cityrooter.clients

import androidx.lifecycle.ViewModel
import com.example.cityrooter.core.reader.JsonFileReaderService
import javax.inject.Inject

class ClientsViewModel @Inject constructor(
    val jsonFileReaderService: JsonFileReaderService
): ViewModel() {

}