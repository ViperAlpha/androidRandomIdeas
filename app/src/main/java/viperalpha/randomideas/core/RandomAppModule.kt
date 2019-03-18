package viperalpha.randomideas.core

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created on 16/03/2019
 * @author Reinaldo Moreira da Silva
 * @email rms_master@hotmail.com
 */
@Module
class RandomAppModule {

    @Singleton
    @Provides
    internal fun provideContext(app: Application): Context = app
}