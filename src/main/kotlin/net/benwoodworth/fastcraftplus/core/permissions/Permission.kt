package net.benwoodworth.fastcraftplus.core.permissions

/**
 * Plugin permissions.
 */
enum class Permission(val Permission: String) {
    USE("fastcraft.use"),

    COMMAND_CRAFT("fastcraft.command.craft"),
    COMMAND_TOGGLE("fastcraft.command.toggle"),
    COMMAND_TOGGLE_OTHER("fastcraft.command.toggle"),

    ADMIN_RELOAD("fastcraft.admin.reload")
}