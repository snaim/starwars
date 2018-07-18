/**
 * Copyright (c) 2017 Ekino
 */
package com.naim.mymusic.ui.mvpekino

import android.os.Bundle
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.SupportFragmentInjector

/**
 * MvpKodeinFragment -
 *
 * @author coutable
 * @version $Id: a2ab7cb477b07d0b9b41e72b898bdd7d3b8b5d6a $
 */
abstract class MvpKodeinFragment<P : BasePresenter>
    : AbstractMvpFragment<P>(), BaseView<P>, SupportFragmentInjector {

    override val injector = KodeinInjector()

    override fun onCreate(savedInstanceState: Bundle?) {
        initializeInjector()
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        destroyInjector()
        super.onDestroy()
    }
}
