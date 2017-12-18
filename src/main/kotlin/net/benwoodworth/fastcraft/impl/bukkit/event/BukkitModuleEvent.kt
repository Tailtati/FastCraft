package net.benwoodworth.fastcraft.impl.bukkit.event

import dagger.Module
import dagger.Provides
import net.benwoodworth.fastcraft.dependencies.event.*
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.server.PluginDisableEvent
import org.bukkit.event.server.PluginEnableEvent
import javax.inject.Singleton
import org.bukkit.event.Listener as Bukkit_Listener
import org.bukkit.plugin.Plugin as Bukkit_Plugin

/**
 * Bukkit implementation of [ModuleEvent]
 */
@Module
class BukkitModuleEvent(
        private var plugin: Bukkit_Plugin
) : ModuleEvent, Bukkit_Listener {

    @Provides @Singleton
    override fun listenerPlayerJoin(): Listener<EventPlayerJoin> {
        return Listener<EventPlayerJoin>().also { listener ->
            Bukkit.getPluginManager().registerEvents(
                    object : Bukkit_Listener {
                        @EventHandler
                        fun onPlayerJoin(event: PlayerJoinEvent) {
                            listener.notifyHandlers(BukkitEventPlayerJoin(event))
                        }
                    },
                    plugin
            )
        }
    }

    @Provides @Singleton
    override fun listenerPluginDisable(): Listener<EventPluginDisable> {
        return Listener<EventPluginDisable>().also { listener ->
            Bukkit.getPluginManager().registerEvents(
                    object : Bukkit_Listener {
                        @EventHandler
                        fun onPluginDisable(event: PluginDisableEvent) {
                            listener.notifyHandlers(BukkitEventPluginDisable(event))
                        }
                    },
                    plugin
            )
        }
    }

    @Provides @Singleton
    override fun listenerPluginEnable(): Listener<EventPluginEnable> {
        return Listener<EventPluginEnable>().also { listener ->
            Bukkit.getPluginManager().registerEvents(
                    object : Bukkit_Listener {
                        @EventHandler
                        fun onPluginEnable(event: PluginEnableEvent) {
                            listener.notifyHandlers(BukkitEventPluginEnable(event))
                        }
                    },
                    plugin
            )
        }
    }
}