package viperalpha.randomideas.features.splash

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import viperalpha.randomideas.R
import viperalpha.randomideas.core.Injectable
import viperalpha.randomideas.core.ui.BaseActivity
import viperalpha.randomideas.databinding.ActivitySplashBinding
import javax.inject.Inject

class SplashActivity : BaseActivity(), Injectable {

    lateinit var binding: ActivitySplashBinding
    @Inject
    lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        init()
    }

    private fun init() {
        binding.lifecycleOwner = this
        binding.model = viewModel.uiModel
    }
}
