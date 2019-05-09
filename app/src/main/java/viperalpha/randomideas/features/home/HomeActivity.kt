package viperalpha.randomideas.features.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_home.*
import viperalpha.randomideas.R
import viperalpha.randomideas.core.ui.BaseActivity

class HomeActivity : BaseActivity() {

    companion object {
        fun startActivity(context: Context){
            context.startActivity(Intent(context,HomeActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

}
