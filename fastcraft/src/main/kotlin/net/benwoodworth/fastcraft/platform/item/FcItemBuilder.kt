package net.benwoodworth.fastcraft.platform.item

import net.benwoodworth.fastcraft.platform.text.FcText

/**
 * A builder that creates Minecraft items.
 */
interface FcItemBuilder {

    /**
     * Set the item type.
     */
    fun type(type: FcItemType): FcItemBuilderTyped

    /**
     * Set the item type.
     */
    fun type(type: FcItemTypes.() -> FcItemType): FcItemBuilderTyped

    /**
     * Build an item based off this [item].
     */
    fun from(item: FcItem): FcItemBuilderTyped
}