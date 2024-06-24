package com.example.shopnet.presenter.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import androidx.lifecycle.lifecycleScope
import com.example.shopnet.databinding.ActivitySplashBinding
import com.example.shopnet.presenter.ui.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        lifecycleScope.launch {
            animateSplashText()
            delay(1000)
            startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
        }
    }
    fun animateSplashText() {
        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.duration = 1000
        binding.splashText.startAnimation(fadeIn)
    }
}