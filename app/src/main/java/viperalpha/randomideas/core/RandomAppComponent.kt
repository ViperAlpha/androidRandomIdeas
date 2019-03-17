package viperalpha.randomideas.core

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created on 16/03/2019
 * @author Reinaldo Moreira da Silva
 * @email rms_master@hotmail.com
 */
@Component(modules = [AndroidSupportInjectionModule::class])
@Singleton
interface RandomAppComponent {

    fun getApp(): Application
    fun inject(app: Application)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): RandomAppComponent
    }
}