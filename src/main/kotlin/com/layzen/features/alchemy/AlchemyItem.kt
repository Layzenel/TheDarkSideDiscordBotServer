package com.layzen.features.alchemy

data class AlchemyItem(
    val alchemyId: String,
    val name: String,
    val effect: String,
    val type: AlchemyType,
    val group: AlchemyGroup
)

enum class AlchemyType(val value: String) {
    ATTACK("ATTACK"), DEFENSE("DEFENSE")
}

enum class AlchemyGroup(val value: String) {
    NO_GROUP("NO_GROUP"), ATTACK("ATTACK"), ADDITIONAL_ATTACK("ADDITIONAL_ATTACK")
}
