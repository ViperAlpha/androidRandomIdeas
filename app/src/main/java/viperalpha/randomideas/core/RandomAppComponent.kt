package viperalpha.randomideas.core

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import viperalpha.randomideas.data.firebase.di.FirebaseModule
import viperalpha.randomideas.features.splash.SplashModule
import javax.inject.Singleton

/**
 * Created on 16/03/2019
 * @author Reinaldo Moreira da Silva
 * @email rms_master@hotmail.com
 */
@Component(modules = [AndroidSupportInjectionModule::class, RandomAppModule::class, SplashModule::class, FirebaseModule::class])
@Singleton
interface RandomAppComponent {

    fun getApp(): Application
    fun inject(app: RandomApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): RandomAppComponent
    }
}