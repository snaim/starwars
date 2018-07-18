package com.naim.mymusic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.AppCompatActivityInjector
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.with
import com.naim.mymusic.ui.AppFragmentNavigator

/**
 * MainActivity -
 *
 * @author naim
 * @version $Id$
 */
class MainActivity : AppCompatActivity(), AppCompatActivityInjector {

    override val injector = KodeinInjector()

    private val navigator: AppFragmentNavigator by injector.with(this).instance()

    companion object {
        /**
         * static boolean to detect process killed and restore issue
         * @see [com.ekino.android.mvp.FragmentNavigator.displayOrRestoreScreenOnActivityCreate]
         * */
        private var isInitialized = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initializeInjector()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        navigator.displayOrRestoreScreenOnActivityCreate(isInitialized)
    }

    override fun onDestroy() {
        destroyInjector()
        super.onDestroy()
    }

    override fun provideOverridingModule() = Kodein.Module {
        constant("FRAGMENT_CONTAINER_ID") with R.id.fragment_container
    }
}
