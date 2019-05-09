package viperalpha.randomideas.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import viperalpha.randomideas.core.ui.ViewModelKey

@Module
abstract class HomeModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeActivity(): HomeActivity

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Module
    companion object {
        @Provides
        fun homeViewModel(HomeActivity: HomeActivity, factory: ViewModelProvider.Factory): HomeViewModel =
            ViewModelProviders.of(HomeActivity, factory).get(HomeViewModel::class.java)
    }

}