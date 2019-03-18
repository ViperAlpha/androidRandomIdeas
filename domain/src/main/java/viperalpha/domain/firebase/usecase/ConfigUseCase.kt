package viperalpha.domain.firebase.usecase

import io.reactivex.Single
import viperalpha.domain.Response
import viperalpha.domain.firebase.contracts.FirebaseConfigRepositoryContract
import viperalpha.domain.firebase.model.RemoteConfig
import javax.inject.Inject

/**
 * Created on 18/03/19
 * @author Reinaldo Moreira da Silva
 * @email rms_master@hotmail.com
 */
class ConfigUseCase @Inject constructor(
    private val configRepository: FirebaseConfigRepositoryContract
) {

    operator fun invoke(key: String, force: Boolean = false): Single<Response<RemoteConfig<String>>> {
        return configRepository.getRemoteStringForKey(key, force)
            .map { Response.success(it) }
    }
}