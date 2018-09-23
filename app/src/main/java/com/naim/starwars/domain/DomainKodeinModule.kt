package com.naim.starwars.domain

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.github.salomonbrys.kodein.singleton
import com.naim.starwars.data.DataRepositoryImpl
import com.naim.starwars.domain.converter.MusicRoomToMusicModelConverter
import com.naim.starwars.domain.converter.MusicToAlbumTrackConverter
import com.naim.starwars.domain.interactor.GetMusicUseCase

/**
 * DomainKodeinModule -
 *
 * @author naim
 * @version $Id$
 */
val domainKodeinModule = Kodein.Module {
    bind<DataRepository>() with singleton { DataRepositoryImpl(instance()) }

    bind<MusicRoomToMusicModelConverter>() with provider { MusicRoomToMusicModelConverter() }
    bind<MusicToAlbumTrackConverter>() with provider { MusicToAlbumTrackConverter() }

    bind<GetMusicUseCase>() with provider { GetMusicUseCase(instance(), instance(), instance()) }
}
