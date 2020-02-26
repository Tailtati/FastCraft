package net.benwoodworth.fastcraft.bukkit.config

import net.benwoodworth.fastcraft.platform.config.FcConfigEntry
import org.bukkit.configuration.file.YamlConfiguration
import java.nio.file.Path

class BukkitFcConfig_1_15_R01(
    override val config: YamlConfiguration
) : BukkitFcConfig {
    override var header: String?
        get() = config.options().header()
        set(value) {
            config.options().header(value)
        }

    override fun save(path: Path) {
        config.save(path.toFile())
    }

    override fun get(key: String): FcConfigEntry {
        return BukkitFcConfigEntry_1_15_R01(key, config, null)
    }
}