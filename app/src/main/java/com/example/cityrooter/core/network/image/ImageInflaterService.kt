package com.example.cityrooter.core.network.image

import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.lang.Exception
import java.net.URL
import javax.inject.Inject

class ImageInflaterService @Inject constructor() {

    suspend fun loadImage(viewLifecycleOwner: LifecycleOwner,
                  url: String,
                  imageView: ImageView){

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            try {
                val inputStream = URL(url).openStream()
            } catch (e: Exception) {

            }
        }
    }
}