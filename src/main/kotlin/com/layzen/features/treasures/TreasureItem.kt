package com.layzen.features.treasures

data class TreasureItem(
    val treasureId: String,
    val name: String,
    val description: String,
    val guideUrl: String,
    val craftImageUrl: String,
    val iconUrl: String,
    val pieces: List<String>,
    val locations: List<String>,
    val monsters: List<String>
)
