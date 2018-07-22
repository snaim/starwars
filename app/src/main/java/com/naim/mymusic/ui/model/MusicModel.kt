package com.naim.mymusic.ui.model

/**
 * MusicModel -
 *
 * @author naim
 * @version $Id$
 */
data class MusicModel(
        val id: Int,
        val albumId: Int,
        val title: String,
        val url: String,
        val thumbnailUrl: String)