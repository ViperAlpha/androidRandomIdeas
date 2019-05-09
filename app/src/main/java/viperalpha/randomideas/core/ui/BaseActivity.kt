package viperalpha.randomideas.core.ui

import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable

/**
 * Created on 17/03/2019
 * @author Reinaldo Moreira da Silva
 * @email rms_master@hotmail.com
 */
abstract class BaseActivity : AppCompatActivity() {
    val onStopDisposable: CompositeDisposable
        get() = CompositeDisposable()

    val onDestroyDisposable: CompositeDisposable
        get() = CompositeDisposable()

    override fun onStop() {
        super.onStop()
        onStopDisposable.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        onDestroyDisposable.clear()
    }
}