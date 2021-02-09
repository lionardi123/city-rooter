package com.id.cityrooter.clients

import androidx.lifecycle.ViewModel
import com.id.cityrooter.core.reader.JsonFileReaderService
import javax.inject.Inject

class ClientsViewModel @Inject constructor(
    val jsonFileReaderService: JsonFileReaderService
): ViewModel() {

}