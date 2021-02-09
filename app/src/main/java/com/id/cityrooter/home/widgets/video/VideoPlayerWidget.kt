package com.id.cityrooter.home.widgets.video

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.id.cityrooter.YoutubePlayerActivity
import com.id.cityrooter.core.views.CoreFrameLayout
import com.id.cityrooter.databinding.VideoPlayerWidgetBinding
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer

class VideoPlayerWidget(context: Context, attributeSet: AttributeSet) :
    CoreFrameLayout(context, attributeSet) {

    private lateinit var binding: VideoPlayerWidgetBinding

    override fun onCreateView(): View {
        binding = VideoPlayerWidgetBinding.inflate(LayoutInflater.from(context), this, true)
        initWidget()
        return binding.root
    }

    private fun initWidget(){
        binding.root.setOnClickListener {
            val intent = Intent(context, YoutubePlayerActivity::class.java)
            context.startActivity(intent)
        }
    }
}