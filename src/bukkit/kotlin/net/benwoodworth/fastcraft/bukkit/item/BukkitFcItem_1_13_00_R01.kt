package net.benwoodworth.fastcraft.bukkit.item

import com.google.auto.factory.AutoFactory
import com.google.auto.factory.Provided
import net.benwoodworth.fastcraft.platform.item.FcItemType
import net.benwoodworth.fastcraft.platform.item.FcItemTypes
import net.benwoodworth.fastcraft.platform.text.FcText
import net.benwoodworth.fastcraft.platform.text.FcTextFactory
import org.bukkit.inventory.ItemStack

@AutoFactory
class BukkitFcItem_1_13_00_R01(
    itemStack: ItemStack,
    @Provided private val itemTypes: FcItemTypes,
    @Provided private val textFactory: FcTextFactory,
    @Provided private val nameProvider: ItemStackNameProvider
) : BukkitFcItem {
    private val itemStack: ItemStack = itemStack.clone()

    override val type: FcItemType by lazy {
        itemTypes.fromMaterial(itemStack.type)
    }

    override val amount: Int
        get() = itemStack.amount

    override val name: FcText by lazy {
        nameProvider.getName(itemStack)
    }

    override val lore: List<FcText> by lazy {
        itemStack
            .takeIf { it.hasItemMeta() }
            ?.itemMeta
            ?.takeIf { it.hasLore() }
            ?.lore
            ?.map { textFactory.createFcText(it ?: "") }
            ?: emptyList()
    }

    override fun toItemStack(): ItemStack {
        return itemStack.clone()
    }
}