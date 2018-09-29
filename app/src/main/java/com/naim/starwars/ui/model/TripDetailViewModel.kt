package com.naim.starwars.ui.model

data class TripDetailViewModel(
        val id: Int,
        val pilotName: String,
        val pilotAvatar: String,
        val departureName: String,
        val departureTime: String,
        val arrivalName: String,
        val arrivalTime: String,
        val distanceValue: String,
        val distanceUnit: String,
        val duration: String,
        val rating: Int,
        val starListResId: List<Int>
)