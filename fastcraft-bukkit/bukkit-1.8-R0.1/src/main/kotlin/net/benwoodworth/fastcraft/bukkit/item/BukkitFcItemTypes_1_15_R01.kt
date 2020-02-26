package net.benwoodworth.fastcraft.bukkit.item

import net.benwoodworth.fastcraft.platform.item.FcItemType
import net.benwoodworth.fastcraft.platform.text.FcTextFactory
import org.bukkit.Material
import javax.inject.Inject

class BukkitFcItemTypes_1_15_R01 @Inject constructor(
    private val textFactory: FcTextFactory
) : BukkitFcItemTypes {
    override val air = fromMaterial(Material.AIR)

    override val ironSword = fromMaterial(Material.IRON_SWORD)

    override val craftingTable = fromMaterial(Material.CRAFTING_TABLE)

    override val anvil = fromMaterial(Material.ANVIL)

    override val netherStar = fromMaterial(Material.NETHER_STAR)

    override fun fromMaterial(material: Material): FcItemType {
        return BukkitFcItemType_1_15_R01(material, textFactory)
    }
}