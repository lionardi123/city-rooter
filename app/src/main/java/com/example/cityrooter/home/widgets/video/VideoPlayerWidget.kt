package com.example.cityrooter.home.widgets.video

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.example.cityrooter.core.views.CoreFrameLayout
import com.example.cityrooter.databinding.VideoPlayerWidgetBinding

class VideoPlayerWidget(context: Context, attributeSet: AttributeSet) :
    CoreFrameLayout(context, attributeSet) {

    private lateinit var binding: VideoPlayerWidgetBinding

    override fun onCreateView(): View {
        binding = VideoPlayerWidgetBinding.inflate(LayoutInflater.from(context), this, true)
        return binding.root
    }
}