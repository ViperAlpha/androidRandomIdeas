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

    override fun getRemoteStringForKey(key: String, force: Boolean): Single<RemoteConfig<String>> {
        return fetch(force)
            .andThen(Single.just(RemoteConfig(key, firebaseRemoteConfig.getString(key))))
    }

    override fun getRemoteBooleanForKey(key: String, force: Boolean): Single<RemoteConfig<Boolean>> {
        return fetch(force)
            .andThen(Single.just(RemoteConfig(key, firebaseRemoteConfig.getBoolean(key))))
    }


    override fun getRemoteLongForKey(key: String, force: Boolean): Single<RemoteConfig<Long>> {
        return fetch(force)
            .andThen(Single.just(RemoteConfig(key, firebaseRemoteConfig.getLong(key))))
    }

    override fun getRemoteDoubleForKey(key: String, force: Boolean): Single<RemoteConfig<Double>> {
        return fetch(force)
            .andThen(Single.just(RemoteConfig(key, firebaseRemoteConfig.getDouble(key))))
    }

    fun fetch(force: Boolean): Completable {
        return firebaseRemoteConfig.fetch(if (force) 0L else FETCH_TIME)
            .listen()
            .doOnComplete { firebaseRemoteConfig.activateFetched() }
    }


}


