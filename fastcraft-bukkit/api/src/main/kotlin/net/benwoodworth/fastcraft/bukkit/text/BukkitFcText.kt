package net.benwoodworth.fastcraft.bukkit.text

import net.benwoodworth.fastcraft.platform.text.FcText
import java.lang.StringBuilder

@Suppress("PropertyName")
interface BukkitFcText : FcText {

    val `bukkitRawText$1_13_R0_1`: String

    fun `bukkitLegacyText$1_13_R0_1`(locale: String): String
}