package com.yuyan

import android.app.Application
import com.yuyan.imemodule.application.Launcher

/**
 * Applicaiton入口
 * @since 2019/6/18
 */
class BaseApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        Launcher.instance.initData(baseContext)
    }
}
