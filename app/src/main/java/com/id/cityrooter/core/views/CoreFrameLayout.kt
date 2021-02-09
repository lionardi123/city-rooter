package com.id.cityrooter.core.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.lifecycle.LifecycleOwner

abstract class CoreFrameLayout(context: Context, attributeSet: AttributeSet?) :
    FrameLayout(context, attributeSet) {

    val lifecycleOwner: LifecycleOwner?
        get() {
            return context as? LifecycleOwner
        }

    init {
        onCreateView()
    }

    abstract fun onCreateView(): View
}