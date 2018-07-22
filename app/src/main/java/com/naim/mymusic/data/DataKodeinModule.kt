package com.naim.mymusic.data

import android.arch.persistence.room.Room
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.naim.mymusic.data.room.Database

/**
 * dataKodeinModule -
 *
 * @author naim
 * @version $Id$
 */
val dataKodeinModule = Kodein.Module {
    bind<Database>() with singleton {
        Room.databaseBuilder(instance(), Database::class.java,
                Database.DATABASE_NAME)
                .build()
    }
}