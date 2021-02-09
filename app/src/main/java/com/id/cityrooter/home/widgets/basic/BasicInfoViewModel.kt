package com.id.cityrooter.home.widgets.basic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.id.cityrooter.datamodel.TitleLabelImageModel
import javax.inject.Inject

class BasicInfoViewModel @Inject constructor(): ViewModel() {
    lateinit var firstItemModel: TitleLabelImageModel
    lateinit var secondItemModel: TitleLabelImageModel
    lateinit var thirdItemModel: TitleLabelImageModel

    internal fun setData(dataModel: List<TitleLabelImageModel>){
        if(dataModel.size == BASIC_INFO_LIMIT) {
            firstItemModel = dataModel[0]
            secondItemModel = dataModel[1]
            thirdItemModel = dataModel[2]
        }
    }

    companion object {
        private const val BASIC_INFO_LIMIT = 3
    }
}