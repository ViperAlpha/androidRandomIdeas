package viperalpha.randomideas.data.firebase.di

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings

import dagger.Module
import dagger.Provides
import viperalpha.domain.firebase.contracts.FirebaseConfigRepositoryContract
import viperalpha.randomideas.BuildConfig
import viperalpha.randomideas.R
import viperalpha.randomideas.data.firebase.FirebaseRepository
import javax.inject.Singleton

/**
 * Created on 17/03/2019
 * @author Reinaldo Moreira da Silva
 * @email rms_master@hotmail.com
 */
@Module
class FirebaseDataModule {

    @Provides
    @Singleton
    internal fun provideRemoteConfig(): FirebaseRemoteConfig {
        val remoteConfig = FirebaseRemoteConfig.getInstance()

        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setDeveloperModeEnabled(BuildConfig.DEBUG)
            .build()
        remoteConfig.setConfigSettings(configSettings)

        remoteConfig.setDefaults(R.xml.remote_config_defaults)

        return remoteConfig
    }

    @Provides
    internal fun provideFirebaseConfigRepo(remoteConfig: FirebaseRemoteConfig): FirebaseConfigRepositoryContract =
        FirebaseRepository(remoteConfig)
}