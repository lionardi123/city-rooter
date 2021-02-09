package com.id.cityrooter

import android.os.Bundle
import android.util.Log
import com.id.cityrooter.databinding.YoutubePlayerActivityBinding
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer

class YoutubePlayerActivity: YouTubeBaseActivity() {

    private lateinit var binding: YoutubePlayerActivityBinding

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        binding = YoutubePlayerActivityBinding.inflate(layoutInflater)
        initWidget()
    }

    private fun initWidget() {
        binding.youtubePlayerView.initialize("AIzaSyA3u8r87_mapy-uxqn3rfZ2bg08zyBtlMs", object: YouTubePlayer.OnInitializedListener {
            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {

            }

            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                player: YouTubePlayer?,
                p2: Boolean
            ) {
                player?.also {
                    it.setFullscreen(true)
                    it.setShowFullscreenButton(false)
                    it.loadVideo("ih2qSy6mrik")
                }
            }
        })
    }
}