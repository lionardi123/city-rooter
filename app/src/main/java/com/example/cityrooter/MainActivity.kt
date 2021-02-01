package com.example.cityrooter

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.cityrooter.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setDisplayShowCustomEnabled(true);
        supportActionBar?.setCustomView(R.layout.action_bar_layout)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue_primary));

        //AIzaSyA3u8r87_mapy-uxqn3rfZ2bg08zyBtlMs
    }

    override fun onStart() {
        super.onStart()
        val navController = findNavController(R.id.navHostContainer)
        activityMainBinding.bottomNavbar.setupWithNavController(navController)
        setListeners()
    }

    private fun setListeners(){
        activityMainBinding.bottomNavbar.menu.get(2).setOnMenuItemClickListener(object :
            MenuItem.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                val phone = "+628117876900"
                val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
                startActivity(intent)
                return true
            }
        })
    }
}