package viperalpha.domain.firebase.model

/**
 * Created on 17/03/2019
 * @author Reinaldo Moreira da Silva
 * @email rms_master@hotmail.com
 */
data class RemoteConfig<valueType>(
        val key: String,
        var value: valueType
) {
    enum class RemoteKey(
            val key: String
    ) {
        WelcomeMessage("welcome_message"),
        WelcomeImage("welcome_image")
    }
}