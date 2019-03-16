package viperalpha.randomideas.core

import android.app.Application
import com.squareup.leakcanary.LeakCanary

/**
 * Created on 16/03/2019
 * @author Reinaldo Moreira da Silva
 * @email rms_master@hotmail.com
 */
class RandomApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}