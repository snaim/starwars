package com.naim.mymusic.data.room.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * MusicRoom -
 *
 * @author naim
 * @version $Id$
 */
@Entity(tableName = "Music")
data class MusicRoom(
        @PrimaryKey val id: Int,
        @ColumnInfo val albumId: Int,
        @ColumnInfo val title: String,
        @ColumnInfo val url: String,
        @ColumnInfo val thumbnailUrl: String)