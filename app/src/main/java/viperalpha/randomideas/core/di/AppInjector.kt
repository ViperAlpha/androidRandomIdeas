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
class AppInjector {
    companion object {

        fun init(app: RandomApp) {
            DaggerRandomAppComponent.builder()
                .application(app)
                .build()
                .inject(app)

            app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
                override fun onActivityPaused(activity: Activity?) {
                }

                override fun onActivityResumed(activity: Activity?) {
                }

                override fun onActivityStarted(activity: Activity?) {
                }

                override fun onActivityDestroyed(activity: Activity?) {
                }

                override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
                }

                override fun onActivityStopped(activity: Activity?) {
                }

                override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                    handleActivity(activity)
                }
            })
        }

        private fun handleActivity(activity: Activity?) {
            if (activity is HasSupportFragmentInjector || activity is Injectable) {
                AndroidInjection.inject(activity)
            }

            if (activity is FragmentActivity) {
                activity.supportFragmentManager.registerFragmentLifecycleCallbacks(object :
                    FragmentManager.FragmentLifecycleCallbacks() {
                    override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
                        if (f is Injectable) {
                            AndroidSupportInjection.inject(f)
                        }
                    }
                }, true)
            }
        }

    }
}