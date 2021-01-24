package com.example.cityrooter.core.reader

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import javax.inject.Inject
import kotlin.reflect.KClass

class JsonFileReaderService @Inject constructor() {
    fun <T: Any> getJsonFromAssets(context: Context,
                          fileName: String,
                          targetClass: KClass<T>): T? {
        var jsonString: String? = null
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        }catch (e: IOException) {
            e.printStackTrace()
        }
        if(jsonString == null) return null
        return Gson().fromJson(jsonString, targetClass.java)
    }
}