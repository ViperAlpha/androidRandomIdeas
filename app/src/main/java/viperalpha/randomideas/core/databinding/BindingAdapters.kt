package viperalpha.randomideas.core.databinding

import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView

/**
 * Created on 18/03/19
 * @author Reinaldo Moreira da Silva
 * @email rms_master@hotmail.com
 */
class BindingAdapters {

    companion object {

        @JvmStatic
        @BindingAdapter("app:uri")
        fun setDraweeImageUri(view: SimpleDraweeView, uri: String?) {
            view.setImageURI(uri)
        }
    }
}