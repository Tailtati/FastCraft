package net.benwoodworth.fastcraft.bukkit.world

import net.benwoodworth.fastcraft.platform.world.FcItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BukkitFcMaterialComparator_1_7 @Inject constructor(
) : BukkitFcMaterialComparator {
    override fun compare(type0: FcItem, type1: FcItem): Int {
        @Suppress("DEPRECATION")
        return type0.material.id - type1.material.id
    }
}
