package com.naim.starwars

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.AppCompatActivityInjector
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.with
import com.naim.starwars.ui.AppFragmentNavigator
import kotlinx.android.synthetic.main.activity_main.progress_bar
import kotlinx.android.synthetic.main.activity_main.toolbar

/**
 * MainActivity -
 *
 * @author naim
 * @version $Id$
 */
class MainActivity : AppCompatActivity(), AppCompatActivityInjector {

    override val injector = KodeinInjector()

    private val navigator: AppFragmentNavigator by injector.with(this).instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        initializeInjector()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        navigator.displayOrRestoreScreenOnActivityCreate(true)
    }

    override fun onDestroy() {
        destroyInjector()
        super.onDestroy()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun provideOverridingModule() = Kodein.Module {
        constant("FRAGMENT_CONTAINER_ID") with R.id.fragment_container
    }

    fun setLoadingState(isLoading: Boolean) {
        progress_bar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    fun setBackActionBar() = setActionBarMode(true)
    fun setTitleActionBar() = setActionBarMode(false)

    private fun setActionBarMode(backMode: Boolean) {
        val actionBar = supportActionBar
        if (actionBar == null) {
            return
        } else {
            actionBar.title = if (backMode) "" else resources.getString(R.string.last_trip)
            val backgroundDrawable =
                    if (backMode) ColorDrawable(Color.TRANSPARENT)
                    else ContextCompat.getDrawable(applicationContext, R.color.colorPrimary)
            actionBar.setBackgroundDrawable(backgroundDrawable)
            actionBar.setDisplayHomeAsUpEnabled(backMode)
            actionBar.setDisplayShowHomeEnabled(backMode)
        }
    }
}
