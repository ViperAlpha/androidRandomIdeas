package viperalpha.randomideas.data.firebase

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import io.reactivex.Completable
import io.reactivex.Single
import viperalpha.domain.firebase.contracts.FirebaseConfigRepositoryContract
import viperalpha.domain.firebase.model.RemoteConfig
import viperalpha.randomideas.data.firebase.ext.listen
import javax.inject.Inject

/**
 * Created on 18/03/19
 * @author Reinaldo Moreira da Silva
 * @email rms_master@hotmail.com
 */
class FirebaseRepository @Inject constructor(
    private val firebaseRemoteConfig: FirebaseRemoteConfig
) : FirebaseConfigRepositoryContract {

    companion object {
        val FETCH_TIME: Long = 4 * 60 * 1000 // 4 horas
    }

    override fun getRemoteStringForKey(keyRemoteString: String, force: Boolean): Single<RemoteConfig<String>> {
        return fetchConfig(force)
            .andThen(Single.just(RemoteConfig(keyRemoteString, firebaseRemoteConfig.getString(keyRemoteString))))
    }

    override fun getRemoteBooleanForKey(keyRemoteBoolean: String, force: Boolean): Single<RemoteConfig<Boolean>> {
        return fetchConfig(force)
            .andThen(Single.just(RemoteConfig(keyRemoteBoolean, firebaseRemoteConfig.getBoolean(keyRemoteBoolean))))
    }


    override fun getRemoteLongForKey(keyRemoteLong: String, force: Boolean): Single<RemoteConfig<Long>> {
        return fetchConfig(force)
            .andThen(Single.just(RemoteConfig(keyRemoteLong, firebaseRemoteConfig.getLong(keyRemoteLong))))
    }

    override fun getRemoteDoubleForKey(keyRemoteDouble: String, force: Boolean): Single<RemoteConfig<Double>> {
        return fetchConfig(force)
            .andThen(Single.just(RemoteConfig(keyRemoteDouble, firebaseRemoteConfig.getDouble(keyRemoteDouble))))
    }

    fun fetchConfig(force: Boolean): Completable {
        return firebaseRemoteConfig.fetch(if (force) 0L else FETCH_TIME)
            .listen()
            .doOnComplete { firebaseRemoteConfig.activateFetched() }
    }


}


