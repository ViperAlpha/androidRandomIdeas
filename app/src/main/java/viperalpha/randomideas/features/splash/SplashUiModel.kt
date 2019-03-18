package viperalpha.randomideas.features.splash

import androidx.databinding.ObservableField
import javax.inject.Inject

/**
 * Created on 18/03/19
 * @author Reinaldo Moreira da Silva
 * @email rms_master@hotmail.com
 */

class SplashUiModel @Inject constructor(
) {
    var welcomeMessage: ObservableField<String> = ObservableField("")
    var welcomeImageUrl: ObservableField<String> = ObservableField("")
}