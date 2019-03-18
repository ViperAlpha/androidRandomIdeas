package viperalpha.randomideas.features.splash

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import kotlinx.android.synthetic.main.activity_splash.*
import viperalpha.randomideas.BaseActivity
import viperalpha.randomideas.R
import viperalpha.randomideas.core.Injectable
import viperalpha.randomideas.databinding.ActivitySplashBinding
import javax.inject.Inject

class SplashActivity : BaseActivity(), Injectable {

    lateinit var binding: ActivitySplashBinding

    @Inject
    lateinit  var remoteConfig: FirebaseRemoteConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        splash_greetings.text = remoteConfig.getString("welcome_message")
    }
}
