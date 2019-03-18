package viperalpha.randomideas.features.splash

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created on 17/03/2019
 * @author Reinaldo Moreira da Silva
 * @email rms_master@hotmail.com
 */
@Module()
abstract class SplashModule {
    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity
}