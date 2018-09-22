package com.naim.starwars

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.AppCompatActivityInjector
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.with
import com.naim.starwars.domain.interactor.RefreshDataFromNetworkUseCase
import com.naim.starwars.ui.AppFragmentNavigator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.progress_bar

/**
 * MainActivity -
 *
 * @author naim
 * @version $Id$
 */
class MainActivity : AppCompatActivity(), AppCompatActivityInjector {

    override val injector = KodeinInjector()

    private val navigator: AppFragmentNavigator by injector.with(this).instance()
    private val refreshDataFromNetworkUseCase: RefreshDataFromNetworkUseCase by injector.instance()

    private lateinit var refreshDataFromNetworkUseCaseDisposable: Disposable

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

        if (!isInitialized) {
            setLoadingState(true)
            refreshDataFromNetworkUseCaseDisposable = refreshDataFromNetworkUseCase.execute()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        setLoadingState(false)
                        isInitialized = true
                        navigator.displayOrRestoreScreenOnActivityCreate(isInitialized)
                    }, {
                        setLoadingState(false)
                    })
        }
    }

    override fun onDestroy() {
        destroyInjector()
        if (this::refreshDataFromNetworkUseCaseDisposable.isInitialized)
            refreshDataFromNetworkUseCaseDisposable.dispose()
        super.onDestroy()
    }

    override fun provideOverridingModule() = Kodein.Module {
        constant("FRAGMENT_CONTAINER_ID") with R.id.fragment_container
    }

    fun setLoadingState(isLoading: Boolean) {
        progress_bar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}
