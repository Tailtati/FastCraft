package net.benwoodworth.fastcraft.dependencies.event

import net.benwoodworth.fastcraft.dependencies.api.player.Player

/**
 * An event for players joining the server.
 */
interface EventPlayerJoin {

    /**
     * The player who joined.
     */
    val player: Player
}