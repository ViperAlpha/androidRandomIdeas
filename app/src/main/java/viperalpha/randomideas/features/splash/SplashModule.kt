package viperalpha.randomideas.features.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import viperalpha.randomideas.core.ui.ViewModelKey

/**
 * Created on 17/03/2019
 * @author Reinaldo Moreira da Silva
 * @email rms_master@hotmail.com
 */
@Module
abstract class SplashModule {

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Module
    companion object {
        @Provides
        fun splashViewModel(splashActivity: SplashActivity, factory: ViewModelProvider.Factory): SplashViewModel =
            ViewModelProviders.of(splashActivity, factory).get(SplashViewModel::class.java)
    }

}