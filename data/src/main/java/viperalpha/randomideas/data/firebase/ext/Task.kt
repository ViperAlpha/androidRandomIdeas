package viperalpha.randomideas.data.firebase.ext

import com.google.android.gms.tasks.Task
import io.reactivex.Completable

/**
 * Created on 18/03/19
 * @author Reinaldo Moreira da Silva
 * @email rms_master@hotmail.com
 */

fun Task<Void>.listen(): Completable {
    return Completable.create { e ->
        addOnFailureListener { exception: Exception -> e.onError(exception) }
        addOnSuccessListener { e.onComplete() }
    }
}