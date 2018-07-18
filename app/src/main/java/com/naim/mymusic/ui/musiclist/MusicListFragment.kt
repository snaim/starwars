package com.naim.mymusic.ui.musiclist

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.naim.mymusic.R
import com.naim.mymusic.ui.mvpekino.MvpKodeinFragment

/**
 * MusicListFragment -
 *
 * @author naim
 * @version $Id$
 */
class MusicListFragment : MvpKodeinFragment<MusicListContract.Presenter>(), MusicListContract.View {

    override val defaultLayout: Int = R.layout.fragment_music_list

    override val presenter: MusicListContract.Presenter by injector.instance()

    companion object {
        fun newInstance(): MusicListFragment {
            return MusicListFragment()
        }
    }

    override fun provideOverridingModule() = Kodein.Module {
        bind<MusicListContract.View>() with instance(this@MusicListFragment)
    }
}
