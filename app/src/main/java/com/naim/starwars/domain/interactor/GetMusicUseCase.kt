package com.naim.starwars.domain.interactor

import com.naim.starwars.domain.DataRepository
import com.naim.starwars.domain.converter.MusicRoomToMusicModelConverter
import com.naim.starwars.domain.converter.MusicToAlbumTrackConverter
import com.naim.starwars.ui.model.MusicModel
import io.reactivex.Observable

/**
 * GetMusicUseCase -
 *
 * @author naim
 * @version $Id$
 */
class GetMusicUseCase(private val dataRepository: DataRepository,
        private val musicRoomToMusicModelConverter: MusicRoomToMusicModelConverter,
        private val musicToAlbumTrackConverter: MusicToAlbumTrackConverter) {

    fun execute(): Observable<Map<Int, List<MusicModel>>> =
            dataRepository.getTripList()
                    .map { musicRoomToMusicModelConverter.convert(it) }
                    .map { musicToAlbumTrackConverter.convert(it) }
}