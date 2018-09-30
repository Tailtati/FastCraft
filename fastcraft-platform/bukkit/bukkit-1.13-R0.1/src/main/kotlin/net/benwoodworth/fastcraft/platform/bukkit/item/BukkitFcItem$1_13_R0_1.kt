package net.benwoodworth.fastcraft.platform.bukkit.item

import net.benwoodworth.fastcraft.platform.bukkit.bukkitItemStack
import net.benwoodworth.fastcraft.platform.bukkit.text.`BukkitFcText$1_13_R0_1`
import org.bukkit.inventory.ItemStack

@Suppress("ClassName")
inline class `BukkitFcItem$1_13_R0_1`(
    override val `bukkitItemStack$1_13_R0_1`: ItemStack
) : BukkitFcItem {

    override val type: `BukkitFcItemType$1_13_R0_1`
        get() = `BukkitFcItemType$1_13_R0_1`(bukkitItemStack.type)

    override val amount: Int
        get() = bukkitItemStack.amount

    override val name: `BukkitFcText$1_13_R0_1`
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override val displayName: `BukkitFcText$1_13_R0_1`?
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override val lore: List<`BukkitFcText$1_13_R0_1`>?
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override val maxStackSize: Int
        get() = bukkitItemStack.maxStackSize

    override val durability: Int
        get() = bukkitItemStack.durability.toInt()
}