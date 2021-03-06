package net.benwoodworth.fastcraft.bukkit.config

import net.benwoodworth.fastcraft.platform.config.FcConfigNode
import org.bukkit.configuration.ConfigurationSection

interface BukkitFcConfigNode : FcConfigNode {
    val config: ConfigurationSection
}

val FcConfigNode.config: ConfigurationSection
    get() = (this as BukkitFcConfigNode).config
