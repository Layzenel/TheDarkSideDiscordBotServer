package com.layzen.features.ancient_anvil

data class AncientAnvilItem(
    val ancientAnvilId: String,
    val group: AncientAnvilGroup,
    val groupName: String,
    val description: String,
    val items: List<String>,
    val values: Map<String, String>
)

enum class AncientAnvilGroup(val value: String) {
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
