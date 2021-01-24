package com.example.cityrooter.core.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

abstract class CoreFrameLayout(context: Context, attributeSet: AttributeSet): FrameLayout(context, attributeSet) {

    init {
        onCreateView()
    }

    abstract fun onCreateView(): View
}