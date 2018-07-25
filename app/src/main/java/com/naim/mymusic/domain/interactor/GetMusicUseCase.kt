package com.naim.mymusic.domain.interactor

import com.naim.mymusic.domain.DataRepository
import com.naim.mymusic.domain.converter.MusicRoomToMusicModelConverter
import com.naim.mymusic.domain.converter.MusicToAlbumTrackConverter
import com.naim.mymusic.ui.model.MusicModel
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
            dataRepository.getMusic()
                    .map { musicRoomToMusicModelConverter.convert(it) }
                    .map { musicToAlbumTrackConverter.convert(it) }
}