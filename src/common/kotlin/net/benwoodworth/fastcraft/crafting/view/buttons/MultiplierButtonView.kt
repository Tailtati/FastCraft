package net.benwoodworth.fastcraft.crafting.view.buttons

import com.google.auto.factory.AutoFactory
import com.google.auto.factory.Provided
import net.benwoodworth.fastcraft.platform.gui.FcGuiButton
import net.benwoodworth.fastcraft.platform.gui.FcGuiClick
import net.benwoodworth.fastcraft.platform.gui.FcGuiClickModifier
import net.benwoodworth.fastcraft.platform.item.FcItemTypes
import net.benwoodworth.fastcraft.platform.text.FcTextColors
import net.benwoodworth.fastcraft.platform.text.FcTextFactory

@AutoFactory
class MultiplierButtonView(
    private val button: FcGuiButton,
    @Provided private val itemTypes: FcItemTypes,
    @Provided private val textFactory: FcTextFactory,
    @Provided private val textColors: FcTextColors
) {
    var multiplier: Int = 1

    lateinit var onIncrement: () -> Unit
    lateinit var onIncrementByOne: () -> Unit
    lateinit var onDecrement: () -> Unit
    lateinit var onDecrementByOne: () -> Unit
    lateinit var onReset: () -> Unit

    private companion object {
        val CLICK_INCREMENT = FcGuiClick.Primary()
        val CLICK_INCREMENT_ONE = FcGuiClick.Primary(FcGuiClickModifier.Shift)
        val CLICK_DECREMENT = FcGuiClick.Secondary()
        val CLICK_DECREMENT_ONE = FcGuiClick.Secondary(FcGuiClickModifier.Shift)
        val CLICK_RESET = FcGuiClick.Middle()
    }

    init {
        button.apply {
            onClick = { event ->
                when (event.click) {
                    CLICK_INCREMENT -> onIncrement()
                    CLICK_INCREMENT_ONE -> onIncrementByOne()
                    CLICK_DECREMENT -> onDecrement()
                    CLICK_DECREMENT_ONE -> onDecrementByOne()
                    CLICK_RESET -> onReset()
                }
            }

            itemType = itemTypes.anvil

            text = textFactory.createFcText("Crafting Multiplier", color = textColors.green)

            description = listOf(
                textFactory.createFcText("Left/right click to increase/decrease", color = textColors.aqua),
                textFactory.createFcText("Shift click to increment by 1", color = textColors.aqua),
                textFactory.createFcText("Middle click to reset to 1x", color = textColors.aqua)
            )

            hideItemDetails()
        }
    }

    fun update() {
        button.amount = multiplier
    }
}
