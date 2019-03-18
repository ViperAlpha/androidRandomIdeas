package viperalpha.domain.firebase.contracts

import io.reactivex.Single
import viperalpha.domain.firebase.model.RemoteConfig

/**
 * Created on 18/03/19
 * @author Reinaldo Moreira da Silva
 * @email rms_master@hotmail.com
 */
interface FirebaseConfigRepositoryContract {

    fun getRemoteStringForKey(key: String, force: Boolean = false): Single<RemoteConfig<String>>
    fun getRemoteBooleanForKey(key: String, force: Boolean = false): Single<RemoteConfig<Boolean>>
    fun getRemoteLongForKey(key: String, force: Boolean = false): Single<RemoteConfig<Long>>
    fun getRemoteDoubleForKey(key: String, force: Boolean = false): Single<RemoteConfig<Double>>
}