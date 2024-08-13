package com.fzxm.canvasdemo.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView.ScaleType.CENTER_CROP
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable

/**
 * Created by xiaoxiaoyu on 2024/8/13.
 */
class TestLottieView  : LottieAnimationView {

      constructor(context: Context?)  : super(context){
          init()
      }

     constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
         init()
     }

     constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
         init()
     }

    private fun init(){
        scaleType = CENTER_CROP
        repeatMode = LottieDrawable.RESTART
        repeatCount = LottieDrawable.INFINITE
        setAnimation(LOADING_LOTTIE_FILE)
        playAnimation()
    }

    companion object{
        private const val LOADING_LOTTIE_FILE = "lottie/create_bot_avatar_loading.json"
    }

}