package com.naim.starwars.data.model

data class TripModel(val id: Int,
                     val pilot: Pilot,
                     val distance: Distance,
                     val duration: Int,
                     val pick_up: TripStep,
                     val drop_off: TripStep)

data class Distance(val value: Long, val unit: String)

data class Pilot(val name: String, val avatar: String, val rating: Float)

data class TripStep(val name: String, val picture: String, val date: String) // TODO