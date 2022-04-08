package com.example.lottiesplash

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.airbnb.lottie.LottieDrawable
import com.example.lottiesplash.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.animationView.addAnimatorListener(object: Animator.AnimatorListener{
            override fun onAnimationStart(p0: Animator?) {
            }

            override fun onAnimationEnd(p0: Animator?) {
                binding.animationView.setAnimation(R.raw.splash_loading)
                binding.animationView.playAnimation()
                binding.animationView.repeatCount= LottieDrawable.INFINITE
                binding.animationView.repeatMode=LottieDrawable.RESTART
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationRepeat(p0: Animator?) {
            }
        })
        hideSystemBars()
    }

    override fun onResume() {
        binding.animationView.resumeAnimation()
        super.onResume()
    }

    override fun onPause() {
        binding.animationView.pauseAnimation()
        super.onPause()
    }

    private fun hideSystemBars() {
        supportActionBar?.hide()
        val windowInsetsController =
            ViewCompat.getWindowInsetsController(window.decorView) ?: return
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }

}