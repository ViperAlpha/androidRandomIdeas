package viperalpha.randomideas.core.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import viperalpha.randomideas.core.DaggerRandomAppComponent
import viperalpha.randomideas.core.Injectable
import viperalpha.randomideas.core.RandomApp

/**
 * Created on 16/03/2019
 * @author Reinaldo Moreira da Silva
 * @email rms_master@hotmail.com
 */
object AppInjector {
    fun init(app: RandomApp) {
        DaggerRandomAppComponent.builder()
            .application(app)
            .build()
            .inject(app)

        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) = handleActivity(activity)
            override fun onActivityPaused(activity: Activity?) = Unit
            override fun onActivityResumed(activity: Activity?) = Unit
            override fun onActivityStarted(activity: Activity?) = Unit
            override fun onActivityDestroyed(activity: Activity?) = Unit
            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) = Unit
            override fun onActivityStopped(activity: Activity?) = Unit

        })
    }

    private fun handleActivity(activity: Activity?) {
        if (activity is HasSupportFragmentInjector || activity is Injectable) {
            AndroidInjection.inject(activity)
        }

        if (activity is FragmentActivity) {
            activity.supportFragmentManager.registerFragmentLifecycleCallbacks(fragmentLifecycleCallbacks(), true)
        }
    }

    class fragmentLifecycleCallbacks : FragmentManager.FragmentLifecycleCallbacks() {
        override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
            if (f is Injectable) {
                AndroidSupportInjection.inject(f)
            }
        }
    }
}