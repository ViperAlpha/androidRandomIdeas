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
        const val FETCH_TIME = 4L * 60 * 60 // 4 horas
    }

    override fun getRemoteStringForKey(keyForString: String, force: Boolean): Single<RemoteConfig<String>> {
        return fetchConfig(force)
            .andThen(Single.just(RemoteConfig(keyForString, firebaseRemoteConfig.getString(keyForString))))
    }

    override fun getRemoteBooleanForKey(keyForBoolean: String, force: Boolean): Single<RemoteConfig<Boolean>> {
        return fetchConfig(force)
            .andThen(Single.just(RemoteConfig(keyForBoolean, firebaseRemoteConfig.getBoolean(keyForBoolean))))
    }


    override fun getRemoteLongForKey(keyForLong: String, force: Boolean): Single<RemoteConfig<Long>> {
        return fetchConfig(force)
            .andThen(Single.just(RemoteConfig(keyForLong, firebaseRemoteConfig.getLong(keyForLong))))
    }

    override fun getRemoteDoubleForKey(keyForDouble: String, force: Boolean): Single<RemoteConfig<Double>> {
        return fetchConfig(force)
            .andThen(Single.just(RemoteConfig(keyForDouble, firebaseRemoteConfig.getDouble(keyForDouble))))
    }

    private fun fetchConfig(force: Boolean): Completable {
        return firebaseRemoteConfig.fetch(if (force) 0L else FETCH_TIME)
            .listen()
            .doOnComplete { firebaseRemoteConfig.activateFetched() }
//            .onErrorComplete()
    }


}


