package viperalpha.randomideas.features.splash

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

    init {
        loadWelcomeMessage()
    }

    private fun loadWelcomeMessage() {
        disposables.add(
            configUseCase(RemoteConfig.RemoteKey.WelcomeMessage.key)
                .subscribe(
                    { value -> uiModel.welcomeMessage.set(value.data?.value) },
                    { t -> uiModel.welcomeMessage.set("Welcome message. ;)") })
        )
    }
}