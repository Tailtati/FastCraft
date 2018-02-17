package net.benwoodworth.fastcraft.implementations.sponge.api.player

import net.benwoodworth.fastcraft.dependencies.api.player.Player
import net.benwoodworth.fastcraft.dependencies.api.text.Text
import net.benwoodworth.fastcraft.implementations.sponge.api.text.SpongeText
import net.benwoodworth.fastcraft.util.Adapter
import java.util.*
import org.spongepowered.api.entity.living.player.Player as Sponge_Player

/**
 * Sponge implementation of [Player].
 */
class SpongePlayer(
        basePlayer: Sponge_Player
) : Player, Adapter<Sponge_Player>(basePlayer) {

    override val username: String
        get() = base.name

    override var displayName: Text?
        get() = SpongeText(base.displayNameData.displayName().get())
        set(value) {
            base.displayNameData.displayName().set(
                    (value as SpongeText).base
            )
        }

    override val uuid: UUID
        get() = base.uniqueId

    override fun sendMessage(message: Text) {
        base.sendMessage(
                (message as SpongeText).base
        )
    }

    override fun hasPermission(permission: String): Boolean {
        return base.hasPermission(permission)
    }
}