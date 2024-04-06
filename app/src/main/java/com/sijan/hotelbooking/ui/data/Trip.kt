package com.sijan.hotelbooking.ui.data

data class Trip(
    val name: String,
    val country: String,
    val days: Int,
    val budget: String,
    val imageRes: String,
    val hotels: List<Hotel> = emptyList(),
    val places: List<Place> = emptyList()
)

data class Hotel(val name: String, val description: String, val imageRes: String)

data class Place(val name: String, val description: String, val imageRes: String)