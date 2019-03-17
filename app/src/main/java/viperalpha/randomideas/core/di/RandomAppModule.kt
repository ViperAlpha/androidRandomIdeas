package viperalpha.randomideas.core.di

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import dagger.Module

/**
 * Created on 16/03/2019
 * @author Reinaldo Moreira da Silva
 * @email rms_master@hotmail.com
 */
@Module
class RandomAppModule {

    abstract companion object {
        abstract fun provideFirebaseRemoteConfig() : FirebaseRemoteConfig
    }
}