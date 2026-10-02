package com.yuyan

import android.app.Application
import android.content.Context
import com.yuyan.imemodule.application.Launcher
import com.yuyan.imemodule.utils.CrashHandler
import com.yuyan.imemodule.utils.ImePerfTrace

/**
 * Applicaiton入口
 * @since 2019/6/18
 */
class BaseApplication : Application(){
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        ImePerfTrace.mark("app.attachBaseContext")
        ImePerfTrace.startMainThreadStallDetector()
    }

    override fun onCreate() {
        super.onCreate()
        ImePerfTrace.mark("app.onCreate begin")
        CrashHandler.instance.init(this)
        ImePerfTrace.mark("app.crashHandlerInit")
        ImePerfTrace.trace("app.launcherInitData") { Launcher.instance.initData(baseContext) }
    }
}
