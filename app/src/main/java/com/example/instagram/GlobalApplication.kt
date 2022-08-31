package com.example.instagram

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication:Application() {
    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, "2ba48ebc23cd1a3772064bcab8e0e90f")
    }
}