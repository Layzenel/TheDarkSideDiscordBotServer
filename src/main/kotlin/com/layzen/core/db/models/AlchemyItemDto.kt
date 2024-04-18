package com.layzen.core.db.models

import com.layzen.features.alchemy.AlchemyGroup
import com.layzen.features.alchemy.AlchemyItem
import com.layzen.features.alchemy.AlchemyType
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class AlchemyItemDto(
    @BsonId val alchemyId: ObjectId = ObjectId(),
    val name: String,
    val effect: String,
    val type: AlchemyTypeDto,
    val group: AlchemyGroupDto,
    val bdoCodexId: String
)

enum class AlchemyTypeDto(val value: String) {
    ATTACK("ATTACK"), DEFENSE("DEFENSE")
}

enum class AlchemyGroupDto(val value: String) {
    NO_GROUP("NO_GROUP"), ATTACK("ATTACK"), ADDITIONAL_ATTACK("ADDITIONAL_ATTACK")
}

fun AlchemyTypeDto.toModel(): AlchemyType = when(this) {
    AlchemyTypeDto.ATTACK -> AlchemyType.ATTACK
    AlchemyTypeDto.DEFENSE -> AlchemyType.DEFENSE
}

fun AlchemyType.toDto(): AlchemyTypeDto = when(this) {
    AlchemyType.ATTACK -> AlchemyTypeDto.ATTACK
    AlchemyType.DEFENSE -> AlchemyTypeDto.DEFENSE
}

fun AlchemyGroupDto.toModel(): AlchemyGroup = when(this) {
    AlchemyGroupDto.NO_GROUP -> AlchemyGroup.NO_GROUP
    AlchemyGroupDto.ATTACK -> AlchemyGroup.ATTACK
    AlchemyGroupDto.ADDITIONAL_ATTACK -> AlchemyGroup.ADDITIONAL_ATTACK
}

fun AlchemyGroup.toDto(): AlchemyGroupDto = when(this) {
    AlchemyGroup.NO_GROUP -> AlchemyGroupDto.NO_GROUP
    AlchemyGroup.ATTACK -> AlchemyGroupDto.ATTACK
    AlchemyGroup.ADDITIONAL_ATTACK -> AlchemyGroupDto.ADDITIONAL_ATTACK
}

fun AlchemyItemDto.toModel(): AlchemyItem = AlchemyItem(
    alchemyId = alchemyId.toString(),
    name = name,
    effect = effect,
    type = type.toModel(),
    group = group.toModel(),
    bdoCodexId = bdoCodexId
)

fun AlchemyItem.toDto(): AlchemyItemDto = AlchemyItemDto(
    name = name,
    effect = effect,
    type = type.toDto(),
    group = group.toDto(),
    bdoCodexId = bdoCodexId
)
