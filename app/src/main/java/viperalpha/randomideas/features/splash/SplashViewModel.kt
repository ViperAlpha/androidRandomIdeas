package viperalpha.randomideas.features.splash

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import viperalpha.domain.firebase.model.RemoteConfig
import viperalpha.domain.firebase.usecase.ConfigUseCase
import viperalpha.randomideas.core.ui.BaseViewModel
import javax.inject.Inject

/**
 * Created on 18/03/19
 * @author Reinaldo Moreira da Silva
 * @email rms_master@hotmail.com
 */
class SplashViewModel @Inject constructor(
    internal val uiModel: SplashUiModel,
    private val configUseCase: ConfigUseCase
) : BaseViewModel() {

    fun start() {
        loadWelcomeMessage()
        loadWelcomeImage()
    }

    private fun loadWelcomeMessage() {
        disposables.add(
            configUseCase(RemoteConfig.RemoteKey.WelcomeMessage.key, true)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { responseWelcomeMessage -> uiModel.welcomeMessage.set(responseWelcomeMessage.data?.value) },
                    { _ -> uiModel.welcomeMessage.set("Error Welcome message. ;(") })
        )
    }

    private fun loadWelcomeImage() {
        disposables.add(
            configUseCase(RemoteConfig.RemoteKey.WelcomeImage.key, true)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { responseWelcomeImage -> uiModel.welcomeImageUrl.set(responseWelcomeImage.data?.value) },
                    { _ -> uiModel.welcomeImageUrl.set("") })
        )
    }
}