package viperalpha.domain.firebase.contracts

import io.reactivex.Single
import viperalpha.domain.firebase.model.RemoteConfig

/**
 * Created on 18/03/19
 * @author Reinaldo Moreira da Silva
 * @email rms_master@hotmail.com
 */
interface FirebaseConfigRepositoryContract {

    fun getRemoteStringForKey(keyRemoteString: String, force: Boolean = false): Single<RemoteConfig<String>>
    fun getRemoteBooleanForKey(keyRemoteBoolean: String, force: Boolean = false): Single<RemoteConfig<Boolean>>
    fun getRemoteLongForKey(keyRemoteLong: String, force: Boolean = false): Single<RemoteConfig<Long>>
    fun getRemoteDoubleForKey(keyRemoteDouble: String, force: Boolean = false): Single<RemoteConfig<Double>>
}