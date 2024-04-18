package com.layzen.core.db.models

import com.layzen.features.ancient_anvil.AncientAnvilGroup
import com.layzen.features.ancient_anvil.AncientAnvilItem
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class AncientAnvilDto(
    @BsonId val ancientAnvilId: ObjectId = ObjectId(),
    val group: AncientAnvilGroupDto,
    val groupName: String,
    val description: String,
    val items: List<String>,
    val values: Map<String, String>
)

enum class AncientAnvilGroupDto(val value: String) {
    BLACK_STAR("BLACK_STAR"),
    GODR_AYED("GODR_AYED"),
    SLUMBERING_ORIGIN("SLUMBERING_ORIGIN"),
    ACCESSORIES_AND_CLOTHES("ACCESSORIES_AND_CLOTHES"),
    CRAFT_ACCESSORIES("CRAFT_ACCESSORIES"),
    CRAFT_CLOTHES("CRAFT_CLOTHES"),
    OTHER("OTHER"),
    GUNS_HARNESS("GUNS_HARNESS"),
    BODY_KIT_CARAVELS_FRIGATES_GREEN("BODY_KIT_CARAVELS_FRIGATES_GREEN"),
    BODY_KIT_CARAVELS_FRIGATES_BLUE("BODY_KIT_CARAVELS_FRIGATES_BLUE"),
    BODY_KIT_GALLEON_PHANOXON_GREEN("BODY_KIT_GALLEON_PHANOXON_GREEN"),
    BODY_KIT_GALLEON_PHANOXON_BLUE("BODY_KIT_GALLEON_PHANOXON_BLUE")
}

fun AncientAnvilGroupDto.toModel(): AncientAnvilGroup = when(this) {
    AncientAnvilGroupDto.BLACK_STAR -> AncientAnvilGroup.BLACK_STAR
    AncientAnvilGroupDto.GODR_AYED -> AncientAnvilGroup.GODR_AYED
    AncientAnvilGroupDto.SLUMBERING_ORIGIN -> AncientAnvilGroup.SLUMBERING_ORIGIN
    AncientAnvilGroupDto.ACCESSORIES_AND_CLOTHES -> AncientAnvilGroup.ACCESSORIES_AND_CLOTHES
    AncientAnvilGroupDto.CRAFT_ACCESSORIES -> AncientAnvilGroup.CRAFT_ACCESSORIES
    AncientAnvilGroupDto.CRAFT_CLOTHES -> AncientAnvilGroup.CRAFT_CLOTHES
    AncientAnvilGroupDto.OTHER -> AncientAnvilGroup.OTHER
    AncientAnvilGroupDto.GUNS_HARNESS -> AncientAnvilGroup.GUNS_HARNESS
    AncientAnvilGroupDto.BODY_KIT_CARAVELS_FRIGATES_GREEN -> AncientAnvilGroup.BODY_KIT_CARAVELS_FRIGATES_GREEN
    AncientAnvilGroupDto.BODY_KIT_CARAVELS_FRIGATES_BLUE -> AncientAnvilGroup.BODY_KIT_CARAVELS_FRIGATES_BLUE
    AncientAnvilGroupDto.BODY_KIT_GALLEON_PHANOXON_GREEN -> AncientAnvilGroup.BODY_KIT_GALLEON_PHANOXON_GREEN
    AncientAnvilGroupDto.BODY_KIT_GALLEON_PHANOXON_BLUE -> AncientAnvilGroup.BODY_KIT_GALLEON_PHANOXON_BLUE
}

fun AncientAnvilGroup.toDto(): AncientAnvilGroupDto = when(this) {
    AncientAnvilGroup.BLACK_STAR -> AncientAnvilGroupDto.BLACK_STAR
    AncientAnvilGroup.GODR_AYED -> AncientAnvilGroupDto.GODR_AYED
    AncientAnvilGroup.SLUMBERING_ORIGIN -> AncientAnvilGroupDto.SLUMBERING_ORIGIN
    AncientAnvilGroup.ACCESSORIES_AND_CLOTHES -> AncientAnvilGroupDto.ACCESSORIES_AND_CLOTHES
    AncientAnvilGroup.CRAFT_ACCESSORIES -> AncientAnvilGroupDto.CRAFT_ACCESSORIES
    AncientAnvilGroup.CRAFT_CLOTHES -> AncientAnvilGroupDto.CRAFT_CLOTHES
    AncientAnvilGroup.OTHER -> AncientAnvilGroupDto.OTHER
    AncientAnvilGroup.GUNS_HARNESS -> AncientAnvilGroupDto.GUNS_HARNESS
    AncientAnvilGroup.BODY_KIT_CARAVELS_FRIGATES_GREEN -> AncientAnvilGroupDto.BODY_KIT_CARAVELS_FRIGATES_GREEN
    AncientAnvilGroup.BODY_KIT_CARAVELS_FRIGATES_BLUE -> AncientAnvilGroupDto.BODY_KIT_CARAVELS_FRIGATES_BLUE
    AncientAnvilGroup.BODY_KIT_GALLEON_PHANOXON_GREEN -> AncientAnvilGroupDto.BODY_KIT_GALLEON_PHANOXON_GREEN
    AncientAnvilGroup.BODY_KIT_GALLEON_PHANOXON_BLUE -> AncientAnvilGroupDto.BODY_KIT_GALLEON_PHANOXON_BLUE
}

fun AncientAnvilDto.toModel(): AncientAnvilItem = AncientAnvilItem(
    ancientAnvilId = ancientAnvilId.toString(),
    group = group.toModel(),
    groupName = groupName,
    description = description,
    items = items,
    values = values
)

fun AncientAnvilItem.toDto(): AncientAnvilDto = AncientAnvilDto(
    group = group.toDto(),
    groupName = groupName,
    description = description,
    items = items,
    values = values
)